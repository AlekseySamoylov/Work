package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.BankData;
import com.alekseysamoylov.banki.Store.DepositData;
import com.alekseysamoylov.banki.models.Bank;
import com.alekseysamoylov.banki.models.Client;
import com.alekseysamoylov.banki.service.ConnectionJdbc;
import com.alekseysamoylov.banki.service.StaticValues;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class BankEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bank bank = new BankData().getBank(Integer.parseInt(req.getParameter("id")));
        StaticValues.setBankId(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("bank", bank);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/bank/EditBank.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       new BankData().editBank(StaticValues.getBankId(), req.getParameter("bankName"), Integer.valueOf(req.getParameter("bik")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/deposit/view"));
    }
}
