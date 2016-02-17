package com.alekseysamoylov.banki.testsql;

import com.alekseysamoylov.banki.service.ConnectionJdbc;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class EditBankTest {
    @Test
    public void editBank(){
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "UPDATE BANKS SET NAME=?, BIK=? WHERE BANKID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "AA");
            preparedStatement.setInt(2, 33);
            preparedStatement.setInt(3, 4);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
