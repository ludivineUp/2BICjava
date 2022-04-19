package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.KidBook;

@Repository
@Transactional
public interface KidBookRepository extends JpaRepository<KidBook, Integer>{

}
