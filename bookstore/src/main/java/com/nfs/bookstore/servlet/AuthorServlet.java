package com.nfs.bookstore.servlet;

import com.nfs.bookstore.dao.DaoFactory;
import com.nfs.bookstore.entities.Author;
import com.nfs.bookstore.entities.Book;
import com.nfs.bookstore.entities.KidBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuthorServlet", value = "/author")
public class AuthorServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("authorlist",DaoFactory.getAuthorDao().getAll());
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
        if((!author.getFirstname().equals("") && !author.getLastname().equals(""))
            || !author.getPseudo().equals("")) {
            DaoFactory.getAuthorDao().create(author);
            request.getSession().setAttribute("authors", DaoFactory.getAuthorDao().getAll());
            response.sendRedirect(request.getContextPath() + "/author");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/add-author.jsp");
        }
    }
}
