package com.nfs.bookstore.servlet;

import com.nfs.bookstore.dao.DaoFactory;
import com.nfs.bookstore.entities.Book;
import com.nfs.bookstore.entities.KidBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/books")
public class BookServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = DaoFactory.getBookDao().getAll();
        books.addAll(DaoFactory.getKidBookDao().getAll());
        request.getSession().setAttribute("books", books);
        response.sendRedirect(request.getContextPath()+"/books.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book;
        // check box pour Book ou KidBook
        if(request.getParameter("kid") == null){
            book = new Book();
        }else{
            book = new KidBook();
            ((KidBook) book).setAge(Integer.parseInt(request.getParameter("age")));
        }
        book.setTitle(request.getParameter("title"));
        book.setParutionYear(Integer.parseInt(request.getParameter("parution")));

        //pour les auteurs : on récupère la liste en session et on vérifie par rapport à l id
        book.setAuthor(DaoFactory.getAuthorDao().get(Integer.parseInt(request.getParameter("author"))));

        if(book instanceof Book){
            DaoFactory.getBookDao().create(book);
        }else{
            DaoFactory.getKidBookDao().create((KidBook) book);
        }
        response.sendRedirect(request.getContextPath()+"/books");
    }
}
