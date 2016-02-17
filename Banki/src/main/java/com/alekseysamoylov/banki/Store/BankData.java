package com.alekseysamoylov.banki.Store;

import com.alekseysamoylov.banki.models.Bank;
import com.alekseysamoylov.banki.service.ConnectionJdbc;
import com.alekseysamoylov.banki.service.StaticValues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class BankData {
    public void createBank(String bankName, String bik){
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "INSERT INTO BANKS(NAME, BIK) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bankName);
            preparedStatement.setInt(2, Integer.valueOf(bik));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editBank(int bankId, String bankName, int bik){
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "UPDATE BANKS SET NAME=?, BIK=? WHERE BANKID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bankName);
            preparedStatement.setInt(2, bik);
            preparedStatement.setInt(3, bankId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Bank getBank(int id){
        Bank bank = null;
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "SELECT NAME, BIK FROM BANKS WHERE BANKID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                bank = new Bank(id, resultSet.getString(1), Integer.parseInt(resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bank;
    }
}
