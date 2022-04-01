package com.nfs.bookstore.dao;

public class DaoFactory {

    private static AuthorDao authorDao;
    private static CityDao cityDao;
    private static CustomerDao customerDao;
    private static BookDao bookDao;
    private static KidBookDao kidBookDao;
    private static OderDao oderDao;

    private DaoFactory(){}

    public static AuthorDao getAuthorDao(){
        if(authorDao == null){
            authorDao = new AuthorDao();
        }
        return authorDao;
    }

    public static CityDao getCityDao(){
        if(cityDao == null){
            cityDao = new CityDao();
        }
        return cityDao;
    }

    public static CustomerDao getCustomerDao(){
        if(customerDao == null){
            customerDao = new CustomerDao();
        }
        return customerDao;
    }

    public static BookDao getBookDao(){
        if(bookDao == null){
            bookDao = new BookDao();
        }
        return bookDao;
    }

    public static KidBookDao getKidBookDao(){
        if(kidBookDao == null){
            kidBookDao = new KidBookDao();
        }
        return kidBookDao;
    }

    public static OderDao getOderDao() {
        if(oderDao == null){
            oderDao = new OderDao();
        }
        return oderDao;
    }
}
