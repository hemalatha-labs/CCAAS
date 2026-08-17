package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.UserMapper;
import com.CCS.Service.Repo.UserRepo;
import com.CCS.Service.RequestDTO.UserRequestDTO;
import com.CCS.Service.ResponseDTO.UserResponseDTO;
import com.CCS.Service.globalException.DuplicateResourceException;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;


    // GET ALL
    public List<UserResponseDTO> getAllUsers() {

        return userRepo.findAll()
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public UserResponseDTO getUser(UUID id) {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        return userMapper.toResponseDTO(user);
    }


    // CREATE
    public UserResponseDTO newUser(
            UserRequestDTO dto) {

        if (userRepo.existsByEmail(dto.getEmail())) {

            throw new DuplicateResourceException(
                    "Email already exists: " + dto.getEmail());
        }

        User user = userMapper.toEntity(dto);

        return userMapper.toResponseDTO(
                userRepo.save(user));
    }


    // UPDATE
    public UserResponseDTO updateUser(
            UUID id,
            UserRequestDTO dto) {

        User existingUser = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));


        if (dto.getName() != null) {
            existingUser.setName(dto.getName());
        }


        if (dto.getEmail() != null) {

            if (userRepo.existsByEmail(dto.getEmail())
                    && !existingUser.getEmail()
                    .equals(dto.getEmail())) {

                throw new DuplicateResourceException(
                        "Email already exists: "
                                + dto.getEmail());
            }

            existingUser.setEmail(dto.getEmail());
        }


        if (dto.getRole() != null) {
            existingUser.setRole(dto.getRole());
        }


        if (dto.getStatus() != null) {
            existingUser.setStatus(dto.getStatus());
        }


        if (dto.getTenantId() != null) {
            existingUser.setTenantId(dto.getTenantId());
        }


        return userMapper.toResponseDTO(
                userRepo.save(existingUser));
    }


    // DELETE
    public void deleteUser(UUID id) {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        userRepo.delete(user);
    }
}