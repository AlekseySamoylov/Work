package com.alekseysamoylov.banki.servlets;

import com.alekseysamoylov.banki.Store.BankData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class BankCreateServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String bankName = request.getParameter("bankName");
        String bik = request.getParameter("bik");
        new BankData().createBank(bankName, bik);
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/deposit/view"));
    }
}
