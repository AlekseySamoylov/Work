package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.DepositData;
import com.alekseysamoylov.banki.models.BigClass;
import com.alekseysamoylov.banki.models.Deposit;

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
public class DepositEditServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Deposit deposit = new DepositData().getDeposit(Integer.valueOf(req.getParameter("id")));
        BigClass bigClass = new BigClass(deposit);
        req.setAttribute("bigClass", bigClass);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/deposit/EditDeposit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        new DepositData().editDeposit(Integer.parseInt(req.getParameter("id")), req.getParameter("dateTime"), req.getParameter("percent"), req.getParameter("time"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/deposit/view"));
    }
}
