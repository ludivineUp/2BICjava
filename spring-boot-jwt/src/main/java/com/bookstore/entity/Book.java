package com.bookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bookstore.entity.Author;
import com.bookstore.entity.Order;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idbook")
	private int id;
	private String title;
	@Column(name="parutionyear")
	private int parutionYear;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="idauthor")
	private Author author;
	
	@ManyToMany(mappedBy = "books")
	private List<Order> orders;
	
	public Book() {}
	
	public Book(int id, String title, int parutionYear, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.parutionYear = parutionYear;
		this.author = author;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getParutionYear() {
		return parutionYear;
	}
	public void setParutionYear(int parutionYear) {
		this.parutionYear = parutionYear;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", parutionYear=" + parutionYear + ", author=" + author + "]";
	}
	
	

}
