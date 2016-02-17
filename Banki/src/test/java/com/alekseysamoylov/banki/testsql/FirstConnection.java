package com.alekseysamoylov.banki.testsql;

import com.alekseysamoylov.banki.service.ConnectionJdbc;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public class FirstConnection {
    @Test
    public void firstTestSql() throws ClassNotFoundException {
        Connection connection = ConnectionJdbc.getConnection();
        try {
            int id = 0;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT BANKCLIENTID FROM BANKCLIENTS where BANKclientid=1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt(1);
            }
            assertEquals(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionJdbc.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
