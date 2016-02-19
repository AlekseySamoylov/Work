package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.service.ConnectionJdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by alekseysamoylov on 2/18/16.
 */
public class BankDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "DELETE FROM BANKS WHERE BANKID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(request.getParameter("id")));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/deposit/view"));

    }
}
