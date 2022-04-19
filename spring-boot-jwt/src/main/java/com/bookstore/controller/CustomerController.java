package com.bookstore.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Customer;
import com.bookstore.repository.CustomerRepository;

@RestController
@RequestMapping("/auth/customers")	// authentificiation nécessaire
public class CustomerController {
	@Autowired
	private CustomerRepository repo;
	
	@RequestMapping(value = "/", produces="application/json")
	public List<Customer> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable(value = "id") int id){
		return repo.getById(id);
	}

	@PostMapping("/")
	@RolesAllowed("ROLE_ADMIN")
	public Customer create(@RequestBody Customer customer) {
		return repo.save(customer);
	}
	
	
	@PutMapping("/")
	public Customer update(@RequestBody Customer customer) {
		return repo.save(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> delete(@PathVariable(value = "id") int id) {
		repo.deleteById(id);
		return ResponseEntity.ok().body(null);
	}
}
