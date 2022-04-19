package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.City;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer>{

}
