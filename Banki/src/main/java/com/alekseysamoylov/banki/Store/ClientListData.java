package com.alekseysamoylov.banki.Store;

import com.alekseysamoylov.banki.models.Bank;
import com.alekseysamoylov.banki.models.Client;
import com.alekseysamoylov.banki.models.Deposit;
import com.alekseysamoylov.banki.service.ConnectionJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class ClientListData {


    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<Integer, Client>();

    public ConcurrentHashMap<Integer, Client> getClients() {
        try(Connection connection = ConnectionJdbc.getConnection()) {
            String sql = "SELECT * FROM BANKCLIENTS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                this.clients.put(resultSet.getInt(1), new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),  resultSet.getString(5)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.clients;
    }

}
