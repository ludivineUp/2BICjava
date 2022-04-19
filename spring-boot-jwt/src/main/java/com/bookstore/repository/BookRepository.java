package com.bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;


@Repository
@Transactional
public class BookRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	private boolean nocrash = true;
	
	public boolean up() {
		return em.isOpen() && nocrash;
	}
	
	public Book get(int id) {
		Book res = null;
		try {
			res = em.find(Book.class, id);
			nocrash = true;
		}catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Book> getByTitle(String title){
		List<Book> res = null;
		Query query = em.createQuery(
				"SELECT b From Book AS b WHERE b.title LIKE :title");
		// "SELECT b From Book AS b WHERE b.title LIKE " + title BEURKKKKK
		query.setParameter("title", title);
		res = query.getResultList();
		nocrash = true;
		return res;
	}

	public List<Book> getWrittenBefore(int year) {
		List<Book> res = null;
		try {
			//Query query = em.createQuery("SELECT b FROM Book AS b WHERE b.parutionYear < :year");
			//query.setParameter("year", year);
			//res = query.getResultList();
			// use the factory criteria builder
			CriteriaBuilder cb = em.getCriteriaBuilder();
			// create the query
			CriteriaQuery<Book> query = cb.createQuery(Book.class);
			// root indicates we the query wotrks on, it the from of the select
			Root<Book> root = query.from(Book.class);
			//Join<Book,Author> root2 = root.join("idauthor"); // join
			query.select(root).where(cb.lessThan(root.get("parutionYear"), year));
			TypedQuery<Book> result = em.createQuery(query);
			res = result.getResultList();
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
		return res;
	}

	public List<Book> getByAuthor(int idAuthor) {
		List<Book> res = null;
		try {
			Query query = em.createQuery("SELECT b FROM Book AS b WHERE b.author = :author");
			query.setParameter("author", idAuthor);
			res = query.getResultList();
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
		return res;
	}

	public List<Book> getAll() {
		List<Book> res = null;
		try {
			Query query = em.createQuery("SELECT b FROM Book AS b");
			res = query.getResultList();
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
		return res;
	}

	public void save(Book book) {
		try {
			em.persist(book);
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
	}

	public Book update(Book book) {
		try {
			em.merge(book);
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
		return book;
	}

	public void delete(int id) {
		try {
			Query query = em.createQuery(
					"DELETE  FROM Book WHERE id = :id");
			query.setParameter("id", id);
			query.executeUpdate();
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
	}

	public List<Book> getOldest() {
		List<Book> res = null;
		try {
			Query query = em.createQuery(
					"SELECT b FROM Book AS b WHERE b.parutionYear = (SELECT MIN(b1.parutionYear) FROM Book as b1)");
			res = query.getResultList();
			nocrash = true;
		} catch (Exception e) {
			nocrash = false;
			e.printStackTrace();
		}
		return res;
	}
	
	
}