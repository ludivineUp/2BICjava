package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;
@RestController
@RequestMapping("/auth/authors")	// besoin d'être authentifié
public class AuthorController implements HealthIndicator{

	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping(value = "/", produces="application/json")
	public List<Author> getAll(){
		return authorRepository.findAll();
	}

	@PostMapping("/")
	/* JSON example
	 * {
	"lastname" : "body",
	"firstname" : "no"
}
	 */
	public Author create(@RequestBody Author author) {
		return authorRepository.save(author);
	}
	@GetMapping("/{id}")
	public Author getId(@PathVariable(name = "id") int id) {
		return authorRepository.getById(id);
	}
	
	@PutMapping("/")
	/*
	 * JSON example
	 * {
	"id": 1,
	"lastname" : "body",
	"firstname" : "noone"
}
	 */
	public Author update(@RequestBody Author author) {
		return authorRepository.save(author);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Author> get(@PathVariable(value = "id") int id) {
		authorRepository.deleteById(id);
		// to return ok this author has been deleted, 
		//you need to return one http response with code 200 and not this author this time
		return ResponseEntity.ok().body(null);
	}

	@Override
	public Health health() {
		// down :acces db compromis
		
		return null;
	}

}
