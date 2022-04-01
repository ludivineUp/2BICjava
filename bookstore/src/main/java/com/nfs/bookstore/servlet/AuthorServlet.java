package com.nfs.bookstore.servlet;

import com.nfs.bookstore.dao.DaoFactory;
import com.nfs.bookstore.entities.City;
import com.nfs.bookstore.utils.Util;
import com.nfs.bookstore.entities.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthorServlet", value = "/author")
public class AuthorServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // pouse la cohérence du code à l'extrême
        if(request.getSession().getAttribute("authors") == null){
            request.getSession().setAttribute("authors", DaoFactory.getAuthorDao().getAll());
        }
        response.sendRedirect(request.getContextPath()+"/authors.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author = new Author();
        if (request.getParameter("pseudo").length() != 0) {
            author.setPseudo(request.getParameter("pseudo"));
            author.setFirstname("");
            author.setLastname("");
        } else {
            author.setPseudo("");
            author.setFirstname(request.getParameter("first"));
            author.setLastname(request.getParameter("last"));
        }
        DaoFactory.getAuthorDao().create(author);
        request.getSession().setAttribute("authors", DaoFactory.getAuthorDao().getAll());
        response.sendRedirect(request.getContextPath()+"/authors.jsp");
    }
}
