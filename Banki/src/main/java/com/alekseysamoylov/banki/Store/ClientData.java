package com.alekseysamoylov.banki.Store;

import com.alekseysamoylov.banki.models.Bank;
import com.alekseysamoylov.banki.models.Client;
import com.alekseysamoylov.banki.service.ConnectionJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class ClientData {
    public Client createClient(String name, String shortName, String adress, String form){
        Client client = null;
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "INSERT INTO BANKCLIENTS(NAME, SHORTNAME, ADRESS, FORM) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, shortName);
            preparedStatement.setString(3, adress);
            preparedStatement.setString(4, form);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
    public void editClient(int clientId, String name, String shortName, String adress, String form){
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "UPDATE BANKCLIENTS SET NAME=?, SHORTNAME=?, ADRESS=?, FORM=? WHERE BANKCLIENTID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, shortName);
            preparedStatement.setString(3, adress);
            preparedStatement.setString(4, form);
            preparedStatement.setInt(5, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Client getClient(int id){
       Client client = null;
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "SELECT NAME, SHORTNAME, ADRESS, FORM FROM BANKCLIENTS WHERE BANKCLIENTID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                client = new Client(id, resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

}
