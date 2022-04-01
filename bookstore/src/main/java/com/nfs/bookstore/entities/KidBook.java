package com.nfs.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kidbook")
public class KidBook extends Book {

    private int age;

    public KidBook() {
        super();
    }

    public KidBook(int id, String title, int parutionYear, Author author, int age) {
        super(id, title, parutionYear, author);
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
