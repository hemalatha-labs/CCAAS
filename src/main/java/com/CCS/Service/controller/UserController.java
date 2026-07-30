package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.service.annotation.PutExchange;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.Service.UserService;
import com.CCS.Service.model.User;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<User>>> getAllUser(){
		List<User> user = userService.getAllUsers();
		
		return ResponseEntity.ok(new ApiResponse<>("User fetched sucussfully", user, true)
				);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Optional<User>>> getUserById(@PathVariable Long id){
		Optional<User> user = userService.getUser(id);
		
		return ResponseEntity.ok( new ApiResponse<>("User fetched by id", user, true)
				);
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user){
			
		User Createuser = userService.newUser(user);
		
		return ResponseEntity.ok(new ApiResponse<>("User created", Createuser, true)
				);
		
}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<User>> upDateUser(@PathVariable Long id , @RequestBody User user){
		
		User updateUser = userService.updateUser(user);
		
		return ResponseEntity.ok( new ApiResponse<>("User updated successfully", updateUser , true)
				);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable Long id){
		userService.deleteUSer(id);
		
		return ResponseEntity.ok(new ApiResponse<>("User deleted", null, true)
				);
				
	}
	
}
