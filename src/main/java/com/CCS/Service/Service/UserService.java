package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.UserRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers(){
		 return userRepo.findAll();
	}
	
	public Optional<User> getUser(Long id) {
		return userRepo.findById(id);
	}

	public User newUser(User user) {
		return  userRepo.save(user);
	}
	
	public void deleteUSer(Long id) {
		userRepo.deleteById(id);
	}
	
	public User UpdateUser(User user) {
		return userRepo.save(user);
	}
		
}
