package com.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.KidBook;
import com.bookstore.repository.KidBookRepository;

@RestController
@RequestMapping("/kid")
public class KidBookController {

	@Resource
	private KidBookRepository kidBookRepository;
	

	
	@RequestMapping("/")
	//@ResponseBody
	public ResponseEntity<List<KidBook>> getAll(){
		return ResponseEntity.ok().body(kidBookRepository.findAll());
	}

	@PostMapping("/")
	public KidBook create(@RequestBody KidBook book) {
		kidBookRepository.save(book);
		 return book;
	}
	
	@RequestMapping("/id/{id}")
	public KidBook get(@PathVariable(value = "id") int id) {
		return kidBookRepository.getById(id);
	}
	
	@PutMapping("/")
	public KidBook update(@RequestBody KidBook book) {
		return kidBookRepository.save(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<KidBook> delete(@PathVariable(value = "id") int id) {
		kidBookRepository.deleteById(id);
		return ResponseEntity.ok().body(null);
	}
}
