package com.nfs.bookstore.utils;

import com.nfs.bookstore.entities.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Util {

    // static on passe par la classe pour les appeller, pas d'instanciation
    public static List<Author> initFakeAuthors() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(0,"Asimoz", "Isaac"));
        authors.add(new Author(1,"Gudule"));
        return authors;
    }
    public static List<Book> initFakeBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(0,"fondation", 1980, initFakeAuthors().get(0)));
        books.add(new Book(1,"Les Filles mortes se ramassent au scalpel ", 2009, initFakeAuthors().get(1)));
        books.add(new KidBook(2,"Agence Torgnole, frappez fort,", 1991, initFakeAuthors().get(1),6));
        return books;
    }
    public static List<City> initFakeCity(){
        List<City> cities = new ArrayList<>();
        cities.add(new City(0, "Montpellier"));
        cities.add(new City(1, "Rouen"));
        cities.add(new City(2, "Nantes"));
        return cities;
    }
    public static List<Customer> initFakeCustomer(){
        List<Customer> customers = new ArrayList<>();
        List<City> cities = initFakeCity();
        customers.add(new Customer(0,"homer", new City(1, "Rouen"), Language.ENGLISH));
        customers.add(new Customer(1,"bart", new City(2, "Nantes"), Language.ITALIAN));
        customers.add(new Customer(2,"lisa", new City(0, "Montpellier"), Language.FRENCH));
        customers.add(new Customer(3,"marge", new City(1, "Rouen"), Language.FRENCH));
        return customers;
    }
    public static void initFakeData(HttpSession s){
        s.setAttribute("authors", Util.initFakeAuthors());
        s.setAttribute("books", Util.initFakeBook());
        s.setAttribute("customers", Util.initFakeCustomer());
        s.setAttribute("cities", Util.initFakeCity());
    }
}
