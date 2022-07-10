package com.courseTheory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courseTheory.models.User;
import com.courseTheory.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	
	
    // Create User Handler
	@RequestMapping(value="/create-user",method=RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	
	// Update User Handler
	@RequestMapping(value="/update-user",method= RequestMethod.POST)
	public void updateUser(User user, int uid) {
		
		userService.updateUser(user, uid);
	}
	
	
	
	// Delete by ID User Handler
	@RequestMapping(value="/delete-userById",method=RequestMethod.DELETE)
	public void deleteUser(@RequestParam int uid) {
		
		userService.deleteUser(uid);
	}
	
	
	// Delete All User Handler
	@RequestMapping(value="/delete-user",method=RequestMethod.DELETE)
	public void deleteUser() {
		
		System.out.println("Delete User called");
		userService.deleteAll();
		
	}
	
	
	//Get Single User Handler
	@RequestMapping(value="get-userById",method=RequestMethod.GET)
	public User getUser( int uid) {
		User u = userService.getUser(uid);
		return u;
	}
	
	
	// Get all User Handler
	@RequestMapping(value="/get-user",method=RequestMethod.GET)
	public List<User> getUser(){
		
		
		List<User> allusers = userService.getAllUsers();
		return allusers;
		
		
	}
	
}
