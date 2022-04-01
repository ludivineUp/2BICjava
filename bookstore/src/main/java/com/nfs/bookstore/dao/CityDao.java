package com.nfs.bookstore.dao;

import com.nfs.bookstore.entities.City;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CityDao {

    EntityManager em;

    public CityDao(){
        em = PersistenceManager.getEmf().createEntityManager();
    }

    public City add(City c){
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return c;
    }

    public City get(int id){
        City c = new City();
        try{
            c = em.find(City.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public boolean update(City c){
        try{
            em.merge(c);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(City c){
        try{
            em.remove(c);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<City> getAll(){
        List<City> c = new ArrayList<>();
        try{
            Query query = em.createQuery("SELECT c FROM City AS c");
            c = query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public City withName(String name){
        City c = new City();
        try{
            Query query = em.createQuery("SELECT c FROM City AS c WHERE c.name LIKE :name");
            query.setParameter("name", name);
            c = (City) query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
