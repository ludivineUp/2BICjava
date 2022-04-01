package com.nfs.bookstore.servlet;

import com.nfs.bookstore.dao.DaoFactory;
import com.nfs.bookstore.entities.Book;
import com.nfs.bookstore.entities.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "OderServlet", urlPatterns = {"/orders"})
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = DaoFactory.getOderDao().getAll();
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setDay(orders.get(i).getDay());
        }
        request.getSession().setAttribute("orders", orders);
        response.sendRedirect(request.getContextPath()+"/orders.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        order.setDay(LocalDate.now());
        order.setCustomer(DaoFactory.getCustomerDao().get(Integer.parseInt(request.getParameter("customer"))));
        List<Book> books = (List<Book>) request.getSession().getAttribute("books");
        for(Book b : books){
            if(request.getParameter("book-"+b.getId()) != null){
                order.getBooks().add(b);
            }
        }
        DaoFactory.getOderDao().create(order);
        response.sendRedirect(request.getContextPath()+"/orders");
    }
}
