package com.bookstore.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class KidBook extends Book{
	
	private String age;
	
	public String getAge() {
		return this.age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

}
