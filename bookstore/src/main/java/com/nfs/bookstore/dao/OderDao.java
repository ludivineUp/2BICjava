package com.nfs.bookstore.dao;

import com.nfs.bookstore.entities.Author;
import com.nfs.bookstore.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OderDao {

    private EntityManager em;

    public OderDao(){
        em = PersistenceManager.getEmf().createEntityManager();
    }
    public Order create(Order a){
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        return a;
    }

    public Order get(int id){
        return (Order) em.find(Order.class, id);
    }

    public List<Order> getAll(){
        Query query = em.createQuery("SELECT a FROM Order AS a");// le nom de la classe
        return query.getResultList();
    }
}
