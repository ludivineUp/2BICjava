package com.bookstore.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Order;
import com.bookstore.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/", produces="application/json")
	public List<Order> getAll(){
		return orderRepository.findAll();
	}

	@PostMapping("/")
	public Order create(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@RequestMapping("/id/{id}")
	public Order get(@PathVariable(value = "id") Integer id) {
		return orderRepository.getById(id);
	}

	@GetMapping("/currentyear")
	public List<Order> getCurrentYear(){
		return orderRepository.findAll()
				.stream().filter(o -> o.getDay().getYear()==LocalDate.now().getYear()).collect(Collectors.toList());
	}
}
