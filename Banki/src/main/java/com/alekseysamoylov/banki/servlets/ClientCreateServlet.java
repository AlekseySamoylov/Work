package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.ClientData;
import com.alekseysamoylov.banki.service.ConnectionJdbc;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class ClientCreateServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        String adress = request.getParameter("adress");
        String form = request.getParameter("form");
        new ClientData().createClient(name, shortName, adress, form);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/deposit/view"));
    }
}
