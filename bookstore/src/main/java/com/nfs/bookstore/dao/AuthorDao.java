package com.nfs.bookstore.dao;

import com.nfs.bookstore.entities.Author;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

public class AuthorDao {
    //@PersistenceContext(unitName="booksPU")
    private EntityManager em;

    public AuthorDao(){
       em = PersistenceManager.getEmf().createEntityManager();
    }

    public Author create(Author a){
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        return a;
    }

    public List<Author> getAll(){
        Query query = em.createQuery("SELECT a FROM Author AS a");// le nom de la classe
        return query.getResultList();
    }

}
