package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.User;
import com.bookstore.service.JWTUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private JWTUserService userService;

	@RequestMapping("/")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok().body(userService.getAll());
	}


	@PostMapping("/signin")
	public String login(@RequestParam("username") String username, @RequestParam("pass") String password) {
		return userService.signin(username, password);
	}
	@PostMapping("/signup")
	public String signup(@RequestParam("username") String username, @RequestParam("pass") String password) {
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		return userService.signup(user);
	}

}
