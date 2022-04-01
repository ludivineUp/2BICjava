package com.nfs.bookstore.entities;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "idcity")
    private City city;
    @Enumerated
    private Language language;

    public Customer(){}

    public Customer(int id, String name, City city, Language language) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
