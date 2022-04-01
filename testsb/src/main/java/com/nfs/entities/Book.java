package com.nfs.entities;

import java.util.List;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbook")
    private int id;
    private String title;
    @Column(name = "parution")
    private int parutionYear;
    @OneToOne
    @JoinColumn(name = "idauthor")
    private Author author;

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

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", parutionYear=" + parutionYear + ", author=" + author + "]";
    }

}

