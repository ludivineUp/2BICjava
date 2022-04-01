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

@WebServlet(name = "ManageAuthorServlet", urlPatterns = {"/manage-author"})
public class ManageAuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("method").equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            List<Book> booksToDelete = DaoFactory.getBookDao().getByAuthorId(id);
            for(Book b: booksToDelete){
                DaoFactory.getBookDao().delete(b);
            }
            List<KidBook> KidooksToDelete = DaoFactory.getKidBookDao().getByAuthorId(id);
            for(KidBook b: KidooksToDelete){
                DaoFactory.getKidBookDao().delete(b);
            }
            DaoFactory.getAuthorDao().delete(DaoFactory.getAuthorDao().get(id));
            response.sendRedirect(request.getContextPath()+"/author");
        }else if(request.getParameter("method").equals("update")){
            request.getSession().setAttribute("up", true);
            request.getSession().setAttribute("authorToUpdate", DaoFactory.getAuthorDao().get(Integer.parseInt(request.getParameter("id"))));
            response.sendRedirect(request.getContextPath() + "/add-author.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author toUp = (Author) request.getSession().getAttribute("authorToUpdate");
        Author a = DaoFactory.getAuthorDao().get(toUp.getId());
        a.setLastname(request.getParameter("last"));
        a.setFirstname(request.getParameter("first"));
        a.setPseudo(request.getParameter("pseudo"));
        request.getSession().removeAttribute("authorToUpdate");
        request.getSession().removeAttribute("up");
        DaoFactory.getAuthorDao().update(a);
        response.sendRedirect(request.getContextPath()+"/author");
    }
}
