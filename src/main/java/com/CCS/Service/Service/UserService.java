package com.CCS.Service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.UserRepo;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
    private  UserRepo userRepo;

    // Get All Users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Get User By Id
    public User getUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
    }

    // Create User
    public User newUser(User user) {

        if (userRepo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return userRepo.save(user);
    }

    // Update User
    public User updateUser(Long id, User updatedUser) {

        User existingUser = getUser(id);

        if (updatedUser.getName() != null) {
            existingUser.setName(updatedUser.getName());
        }

        if (updatedUser.getEmail() != null) {

            if (userRepo.existsByEmail(updatedUser.getEmail())
                    && !existingUser.getEmail().equals(updatedUser.getEmail())) {

                throw new RuntimeException("Email already exists");
            }

            existingUser.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getRole() != null) {
            existingUser.setRole(updatedUser.getRole());
        }

        if (updatedUser.getStatus() != null) {
            existingUser.setStatus(updatedUser.getStatus());
        }

        return userRepo.save(existingUser);
    }

    // Delete User
    public void deleteUser(Long id) {

        User user = getUser(id);

        userRepo.delete(user);
    }

	
}