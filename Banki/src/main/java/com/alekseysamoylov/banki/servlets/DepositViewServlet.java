package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.DepositData;
import com.alekseysamoylov.banki.models.Deposit;
import com.alekseysamoylov.banki.service.ConnectionJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class DepositViewServlet extends HttpServlet{

    private static final DepositData DEPOSIT_CACHE = DepositData.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("deposits", DEPOSIT_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/deposit/DepositView.jsp");
        dispatcher.forward(req, resp);
    }



}
