package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
@RestController
@RequestMapping("/books")	// public
public class BookController implements HealthIndicator{
	
	@Autowired
	private BookRepository bookRepository;

	
	@RequestMapping("/")
	//@ResponseBody
	public ResponseEntity<List<Book>> getAll(){
		return ResponseEntity.ok().body(bookRepository.getAll());
	}

	@PostMapping("/")
	public Book create(@RequestBody Book book) {
		 bookRepository.save(book);
		 return book;
	}
	
	@RequestMapping("/id/{id}")
	public Book get(@PathVariable(value = "id") int id) {
		return bookRepository.get(id);
	}
	
	@PutMapping("/")
	public Book update(@RequestBody Book book) {
		return bookRepository.update(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Book> delete(@PathVariable(value = "id") int id) {
		bookRepository.delete(id);
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping("/before/{year}")
	public List<Book>  getBefore(@PathVariable(value = "year") int year){
		return bookRepository.getWrittenBefore(year);
	}

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return bookRepository.up() ? Health.up().build() 
				: Health.down().build();
	}

}
