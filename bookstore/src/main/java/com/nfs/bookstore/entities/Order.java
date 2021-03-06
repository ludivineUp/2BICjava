package com.nfs.bookstore.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder")
    private int id;
    // non save en DB
    @Transient
    private LocalDate day;
    @Temporal(TemporalType.DATE)
    private Date orderday;
    @ManyToMany
    @JoinTable(name="books_orders")
    private List<Book> books;
    // si l'arder est affacé, ça efface le client en base également
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idcustomer")
    private Customer customer;
    @Transient
    private String dayAsString;
    @Transient
    private DateTimeFormatter dtf;

    public Order(){
        books = new ArrayList<>();
        dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        if(day != null) {
            this.orderday = java.sql.Date.valueOf(day);
            this.dayAsString = day.format(dtf);
            this.day = day;
        }
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderday() {
        return orderday;
    }

    public void setOrderday(Date orderday) {
        this.orderday = orderday;
        this.day = new java.sql.Date(orderday.getTime()).toLocalDate();
        this.dayAsString = day.format(dtf);
    }

    public String getDayAsString() {
        this.day = new java.sql.Date(orderday.getTime()).toLocalDate();
        this.dayAsString = day.format(dtf);
        return dayAsString;
    }

    public void setDayAsString(String dayAsString) {
        if(dayAsString != null)
            this.dayAsString = dayAsString;
    }
}
