package com.nfs.bookstore.dao;

import com.nfs.bookstore.entities.Author;
import com.nfs.bookstore.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookDao {
    private EntityManager em;

    public BookDao(){
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public Book create(Book b){
        try {
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        return b;
    }

    public List<Book> getAll(){
        Query query = em.createQuery("SELECT a FROM Book AS a");// le nom de la classe
        return query.getResultList();
    }



    public List<Book> getByAuthorId(int id){
        Query query = em.createQuery("SELECT a FROM Book AS a WHERE author.id = :id");// le nom de la classe
        query.setParameter("id", id);
        return query.getResultList();
    }

    public boolean delete(Book a){
        try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
