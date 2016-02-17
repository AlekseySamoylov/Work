package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.DepositData;
import com.alekseysamoylov.banki.models.BigClass;
import com.alekseysamoylov.banki.models.Deposit;
import com.alekseysamoylov.banki.service.StaticValues;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class DepositCreateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigClass bigClass = new BigClass();
        req.setAttribute("bigClass", bigClass);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/deposit/CreateDeposit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("clientCId"));
        new DepositData().createDeposit(Integer.parseInt(req.getParameter("clientCId")),
                Integer.parseInt(req.getParameter("bankId")), req.getParameter("dateTime"),
                Integer.parseInt(req.getParameter("percent")), Integer.parseInt(req.getParameter("time")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/deposit/view"));
    }
}