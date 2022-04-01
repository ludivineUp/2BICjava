package com.nfs.bookstore.servlet.listener;

import com.nfs.bookstore.dao.DaoFactory;
import com.nfs.bookstore.dao.PersistenceManager;
import com.nfs.bookstore.entities.*;
import com.nfs.bookstore.utils.Util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class BookStoreListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public BookStoreListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        // fermer la connection à la base
        PersistenceManager.getEmf().close();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //initFakeData(se);
        se.getSession().setAttribute("authors",DaoFactory.getAuthorDao().getAll());
        List<String> ls = new ArrayList<>();
        for(Language l : Language.values()){
            ls.add(l.toString());
        }
        se.getSession().setAttribute("languages",ls);
        se.getSession().setAttribute("cities",DaoFactory.getCityDao().getAll());
        System.out.println("end init data");
    }

    private void initFakeData(HttpSessionEvent se) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(0,"Asimoz", "Isaac"));
        authors.add(new Author(1,"Gudule"));
        se.getSession().setAttribute("authors", authors);
        List<Book> books = new ArrayList<>();
        books.add(new Book(0,"fondation", 1980, authors.get(0)));
        books.add(new Book(1,"Les Filles mortes se ramassent au scalpel ", 2009, authors.get(1)));
        books.add(new KidBook(2,"Agence Torgnole, frappez fort,", 1991, authors.get(1),6));
        se.getSession().setAttribute("books", books);
        List<City> cities = new ArrayList<>();
        cities.add(new City(0, "Montpellier"));
        cities.add(new City(1, "Rouen"));
        cities.add(new City(2, "Nantes"));
        se.getSession().setAttribute("cities", cities);
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(0,"homer", cities.get(1), Language.ENGLISH));
        customers.add(new Customer(1,"bart", cities.get(2), Language.ITALIAN));
        customers.add(new Customer(2,"lisa", cities.get(0), Language.FRENCH));
        customers.add(new Customer(3,"marge", cities.get(1), Language.FRENCH));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
