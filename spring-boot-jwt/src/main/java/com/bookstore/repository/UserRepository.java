package com.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.username = ?1") //JPQL : on travaille sur les classe et non les tables
	Optional<User> findUserWithName(String username);
}
