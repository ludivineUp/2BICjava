package com.nfs.bookstore.servlet.filter;

import com.nfs.bookstore.dao.DaoFactory;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "OrderLoadDataFilter", urlPatterns = {"/add-order.jsp"})
public class OrderLoadDataFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ((HttpServletRequest) request).getSession().setAttribute("books", DaoFactory.getBookDao().getAll());
        ((HttpServletRequest) request).getSession().setAttribute("customers", DaoFactory.getCustomerDao().getAll());
        chain.doFilter(request, response);
    }
}
