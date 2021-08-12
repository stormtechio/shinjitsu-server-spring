  package com.stormtechio.shinjitsu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stormtechio.shinjitsu.model.User;
import com.stormtechio.shinjitsu.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	@ResponseBody
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public User getUserById(@PathVariable Long id){
		return this.userService.getUserById(id);
	}
	
	@PostMapping("/")
	@ResponseBody
	public Map<String, String> createUser(@RequestBody User user){
		return this.userService.create(user);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public Map<String, String> updateUser(@RequestBody User user, @PathVariable Long id){
		return this.userService.updateUser(user, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, String> deleteUser(@PathVariable Long id){
		return this.userService.deleteUser(id);
	}
	
	
	

}
