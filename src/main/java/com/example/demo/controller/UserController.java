package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;


@RestController
public class UserController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/saveUSer")
	public String saveUser(@RequestBody User user) {
		repository.save(user);
		return "User saved";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/getUser/{id}")
	public List<User> getUserById(@PathVariable int id){
		return repository.findById(id);
	}
}
