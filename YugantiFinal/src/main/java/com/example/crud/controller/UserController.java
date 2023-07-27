package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private UserRepository repo;
	@PostMapping("/user")
	public ResponseEntity<User>registerUser(@RequestBody User user) {
		
		System.out.println("User Controller Called");
		return ResponseEntity.ok(repo.save(user));
		
		
	}
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = repo.findAll();
        return ResponseEntity.ok(users);
    }
}
