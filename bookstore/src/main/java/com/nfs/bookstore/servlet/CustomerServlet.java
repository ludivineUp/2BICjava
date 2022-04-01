package com.nfs.bookstore.servlet;

import com.nfs.bookstore.entities.Language;
import com.nfs.bookstore.utils.Util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("customers"));
        for(Language l : Language.values()){
            System.out.println(l);
        }
        response.sendRedirect(request.getContextPath()+"/customers.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
