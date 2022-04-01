package com.nfs.bookstore.servlet;

import com.nfs.bookstore.dao.DaoFactory;
import com.nfs.bookstore.entities.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("cities", DaoFactory.getCityDao().getAll());
        request.getSession().setAttribute("customers", DaoFactory.getCustomerDao().getAll());
        response.sendRedirect(request.getContextPath()+"/customers.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setCity(DaoFactory.getCityDao().get(Integer.parseInt(request.getParameter("city"))));
        String lg = request.getParameter("lg");
        for(Language l : Language.values()){
            if(lg.equals(l.toString())){
                customer.setLanguage(l);
                break;
            }
        }
        DaoFactory.getCustomerDao().create(customer);
        response.sendRedirect(request.getContextPath()+"/customers");
    }
}
