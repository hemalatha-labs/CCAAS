
package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.UserRepo;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserService {
	
    
	private final UserRepo userRepo;
	
	public List<User> getAllUsers(){
		 return userRepo.findAll();
	}
	
	public Optional<User> getUser(Long id) {
		return userRepo.findById(id)
				.orElseThrow(() ->
				     new ResourceNotFoundException("User not found with id: "+id));
	}
	public User updateUser(Long id, User updatedUser) {

	    User existing = getUser(id);

	    if (updatedUser.getName() != null) {
	        existing.setName(updatedUser.getName());
	    }

	    if (updatedUser.getEmail() != null) {

	        if (userRepo.existsByEmail(updatedUser.getEmail())
	                && !existing.getEmail().equals(updatedUser.getEmail())) {

	            throw new RuntimeException("Email already exists");
	        }

	        existing.setEmail(updatedUser.getEmail());
	    }

	    if (updatedUser.getRole() != null) {
	        existing.setRole(updatedUser.getRole());
	    }

	    if (updatedUser.getStatus() != null) {
	        existing.setStatus(updatedUser.getStatus());
	    }

	    return userRepo.save(existing);
	}
	

	public User newUser(User user) {
		
		return  userRepo.save(user);
	}
	
	public void deleteUSer(Long id) {
		userRepo.deleteById(id);
	}
	
		
}
