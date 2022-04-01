package com.nfs.bookstore.entities;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauthor")
    private int id;
    private String firstname;
    private String lastname;
    private String pseudo;

    public Author() {
        this.firstname = "";
        this.lastname = "";
        this.pseudo = "";
    }
    public Author(int id, String firstname, String lastname) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Author(int id, String pseudo) {
        super();
        this.id = id;
        this.pseudo = pseudo;
    }

    public Author(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Author(String pseudo) {
        super();
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}
