package com.alekseysamoylov.carrepair;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

/*
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public class ClientInOrderController implements Initializable{


    private ObservableList<ClientTableView> data;
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<ClientTableView> tableView;
    @FXML private TableColumn<ClientTableView, Integer> clientId;
    @FXML private TableColumn<ClientTableView, String> firstName;
    @FXML private TableColumn<ClientTableView, String> secondName;
    @FXML private TableColumn<ClientTableView, String> phone;

    @FXML private void clickClientCars() throws IOException {
        StaticValues.setClientId(tableView.getSelectionModel().getSelectedItem().getClientId());
        stageClose();
        new NewStage("/fxml/clientCars.fxml");
    }

    @FXML private void clickClientCars2() throws IOException {
        StaticValues.setClientId(tableView.getSelectionModel().getSelectedItem().getClientId());
        stageClose();
        new NewStage("/fxml/clientsCars2.fxml");
    }

    @FXML
    private void clickOnBackMain() throws IOException {
        new StageClose(label);
        new NewStage("/fxml/mainStage.fxml");
    }

    @FXML
    private void clickOnBack() throws IOException {
        new StageClose(label);
        new NewStage("/fxml/purchaseOrder.fxml");
    }

    @FXML
    private void clickOnButton() throws IOException {
        stageClose();
        new NewStage("/fxml/clientAdd.fxml");
    }

    @FXML
    private void clickOnButton2() throws IOException {
        stageClose();
        new NewStage("/fxml/clientAdd2.fxml");
    }


    @FXML
    private void clickDelete() throws ClassNotFoundException, SQLException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление клиента");
        alert.setHeaderText("Удаление клиента");
        alert.setContentText("Вы уверены, что хотите удалить данные о клиенте?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            int clId = tableView.getSelectionModel().getSelectedItem().getClientId();
            Connection conn = DataBaseConnection.connectionOpen();
            String sql = "DELETE FROM clients WHERE (clientId = ?)";
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setInt(1, clId);
            prepare.executeUpdate();
            refreshList();
            filterField.setText("");
            label.setText("Клиент удален");

        } else {
            alert.close();
        }


    }
    @FXML
    private void clickUpdate(){
        StaticValues.setClientId(tableView.getSelectionModel().getSelectedItem().getClientId());
        System.out.println(tableView.getSelectionModel().getSelectedItem().getClientId() + "||" + StaticValues.getClientId());
        stageClose();
        try {
            new NewStage("/fxml/clientUpdate.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void clickUpdate2(){
        StaticValues.setClientId(tableView.getSelectionModel().getSelectedItem().getClientId());
        System.out.println(tableView.getSelectionModel().getSelectedItem().getClientId() + "||" + StaticValues.getClientId());
        stageClose();
        try {
            new NewStage("/fxml/clientUpdate2.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshList();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }




    private void refreshList() throws ClassNotFoundException, SQLException {
        tableView.setRowFactory( tv ->{
            TableRow<ClientTableView> row = new TableRow<>();
            row.setOnMouseClicked(event ->{
                if(event.getClickCount() == 2 && (!row.isEmpty()) && (!label.getText().equals("Управление списком клиентов"))){
                    try {
                        clickClientCars();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else  if (event.getClickCount() == 2 && (!row.isEmpty()) && (label.getText().equals("Управление списком клиентов"))){
                    try {
                        clickClientCars2();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });

        clientId.setCellValueFactory(
                new PropertyValueFactory<>("clientId"));
        firstName.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
        secondName.setCellValueFactory(
                new PropertyValueFactory<>("secondName"));
        phone.setCellValueFactory(
                new PropertyValueFactory<>("phone"));

        data = FXCollections.observableArrayList();

        Connection conn = DataBaseConnection.connectionOpen();
        String sql = "SELECT * FROM clients ORDER BY secondName";
        PreparedStatement prepare = conn.prepareStatement(sql);
        ResultSet result = prepare.executeQuery();
        while(result.next()){
            ClientTableView clientTableView = new ClientTableView();
            clientTableView.clientId.set(result.getInt("clientId"));
            clientTableView.firstName.set(result.getString("firstName"));
            clientTableView.secondName.set(result.getString("secondName"));
            clientTableView.phone.set(result.getString("phone"));
            data.add(clientTableView);

        }
        tableView.setItems(data);

        search();
    }


    private void search(){
        FilteredList<ClientTableView> filteredData = new FilteredList<>(data, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(tableView -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (tableView.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (tableView.getSecondName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<ClientTableView> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);
    }
    private void stageClose(){
        Stage stage = (Stage) label.getScene().getWindow();
        stage.close();
    }
}
