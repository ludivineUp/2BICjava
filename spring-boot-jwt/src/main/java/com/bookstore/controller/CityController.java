package com.bookstore.controller;

import java.util.List;

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

import com.bookstore.entity.City;
import com.bookstore.repository.CityRepository;

@RestController
@RequestMapping("/city")	// public
public class CityController {
	@Autowired
	private CityRepository cityRepository;
	
	@RequestMapping(value = "/", produces="application/json")
	public List<City> getAll(){
		return cityRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public City get(@PathVariable(value = "id") int id){
		return cityRepository.getById(id);
	}

	@PostMapping("/")
	public City create(@RequestBody City city) {
		return cityRepository.save(city);
	}
	
	
	@PutMapping("/")
	public City update(@RequestBody City city) {
		return cityRepository.save(city);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<City> delete(@PathVariable(value = "id") int id) {
		cityRepository.deleteById(id);
		return ResponseEntity.ok().body(null);
	}
}
