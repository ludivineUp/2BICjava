package com.nfs.bookstore.dao;

public class DaoFactory {

    private static AuthorDao authorDao;
    private static CityDao cityDao;

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
}
