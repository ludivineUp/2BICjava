package com.nfs.bookstore.dao;

import com.nfs.bookstore.entities.Book;
import com.nfs.bookstore.entities.KidBook;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class KidBookDao {

    private EntityManager em;

    public KidBookDao(){
        this.em = PersistenceManager.getEmf().createEntityManager();
    }

    public KidBook create(KidBook b){
        try {
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        return b;
    }

    public List<KidBook> getAll(){
        List<KidBook> kbs = new ArrayList<>();
        Query query = em.createQuery("SELECT k FROM KidBook AS k");// le nom de la classe
           if(query.getResultList() != null){
               kbs = query.getResultList();
           }
       return kbs;
    }
    public List<KidBook> getByAuthorId(int id){
        Query query = em.createQuery("SELECT a FROM Book AS a WHERE author.id = :id");// le nom de la classe
        query.setParameter("id", id);
        return query.getResultList();
    }

    public boolean delete(KidBook a){
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
