package org.flightmanagementsystem.controller;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.Service.UserService;
import org.flightmanagementsystem.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight/users")
public class UserController {
	
	//Dependency Injection
	private UserService userService;

	//Constructor injection
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//creating user REST API
	
	//addUser method
	@PostMapping()
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	//view single user
	@GetMapping("{id}")
	public ResponseEntity<User> viewUser(@PathVariable("id") BigInteger UserId){
		return new ResponseEntity<User>(userService.viewUser(UserId), HttpStatus.OK);
	}
	
	//view all user
	@GetMapping
	public List<User> viewAllUser(){
		return userService.viewAllUser();
	}
	
	//update user details
	@PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") BigInteger id,
    		@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	//Delete user
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") BigInteger id){
	userService.deleteUser(id);
	return new ResponseEntity<String>("Employee deleted Successfully!",HttpStatus.OK);
	
	}

}
