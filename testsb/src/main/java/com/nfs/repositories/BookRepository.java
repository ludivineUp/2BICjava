package com.nfs.repositories;

import com.nfs.entities.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookRepository {
    @PersistenceContext
    private EntityManager em;

    public Book get(int id) {
        Book res = null;
        try {
            res = em.find(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public List<Book> getByTitle(String title) {
        List<Book> res = null;
        try {
            Query query = em.createQuery("SELECT b FROM Book AS b where b.title = :title");
            query.setParameter("title", title);
            res = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
