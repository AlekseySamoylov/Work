package com.alekseysamoylov.banki.testsql;

import com.alekseysamoylov.banki.service.ConnectionJdbc;
import org.junit.Test;

import java.sql.*;

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
            PreparedStatement statement = connection.prepareStatement("UPDATE BANKS SET NAME='ВАСЯ' WHERE BANKID=8");
            statement.executeUpdate();
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
