package com.alekseysamoylov.banki.Store;

import com.alekseysamoylov.banki.models.Bank;
import com.alekseysamoylov.banki.models.Client;
import com.alekseysamoylov.banki.models.Deposit;
import com.alekseysamoylov.banki.service.ConnectionJdbc;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class BankListData {
    private final ConcurrentHashMap<Integer, Bank> banks = new ConcurrentHashMap<Integer, Bank>();

    public ConcurrentHashMap<Integer, Bank> getBanks() {
        try(Connection connection = ConnectionJdbc.getConnection()) {
            String sql = "SELECT * FROM BANKS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                this.banks.put(resultSet.getInt(1), new Bank(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.banks;
    }

}
