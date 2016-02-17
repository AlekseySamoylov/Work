package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.BankData;
import com.alekseysamoylov.banki.Store.ClientData;
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

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class ClientEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = new ClientData().getClient(Integer.parseInt(req.getParameter("id")));
        StaticValues.setClientId(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("client", client);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/EditClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ClientData().editClient(StaticValues.getClientId(), req.getParameter("name"), req.getParameter("shortName"),
                req.getParameter("adress"), req.getParameter("form"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/deposit/view"));
    }
}
