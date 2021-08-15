package com.test.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.service.impl.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class UserRestController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAlluser(Model model) {
		List<User> listUser = userService.findAll();
		if (listUser.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listUser);
	}
	
	@GetMapping("/user/{username}")	
	public ResponseEntity<User> findOneUser(
			@PathVariable("username") String username) {
		if (userService.findById(username).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userService.findById(username).get());
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> postUser(@RequestBody User user){
		if (!userService.findById(user.getUsername()).isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		userService.createUser(user);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> putUser(@RequestBody User user) {
		if (userService.findById(user.getUsername()).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
			userService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/user/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String username) {
		if (userService.findById(username).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteUser(username);
		return ResponseEntity.ok().build();
	}
	
	 @GetMapping("/userProperty/{email}")
		public ResponseEntity<List<User>> findEmailUser(@PathVariable("email") String email) {

			return ResponseEntity.ok(userService.findByEmail(email));
	 }
}
