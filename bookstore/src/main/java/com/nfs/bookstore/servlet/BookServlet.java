package com.nfs.bookstore.servlet;

import com.nfs.bookstore.utils.Util;
import com.nfs.bookstore.entities.Author;
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
        if(request.getSession().getAttribute("books") == null){
            request.getSession().setAttribute("books", Util.initFakeBook());
        }
        response.sendRedirect(request.getContextPath()+"/books.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = (List<Book>) request.getSession().getAttribute("books");
        if(books == null){
            books = Util.initFakeBook();
        }

        Book book;
        // check box pour Book ou KidBook
        if(request.getParameter("kid") == null){
            book = new Book();
        }else{
            book = new KidBook();
            ((KidBook) book).setAge(Integer.parseInt(request.getParameter("age")));
        }
        book.setId(Integer.parseInt(request.getParameter("isbn")));
        book.setTitle(request.getParameter("title"));
        book.setParutionYear(Integer.parseInt(request.getParameter("parution")));

        //pour les auteurs : on récupère la liste en session et on vérifie par rapport à l id
        int id = Integer.parseInt(request.getParameter("author"));
        for(Author author : (List<Author>) request.getSession().getAttribute("authors")){
            if(author.getId() == id){
                book.setAuthor(author);
                break;
            }
        }

        //on ajoute le livre à la liste
        books.add(book);
        request.getSession().setAttribute("books", books);
        response.sendRedirect(request.getContextPath()+"books.jsp");
    }
}
