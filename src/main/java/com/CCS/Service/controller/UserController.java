package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.UserRequestDTO;
import com.CCS.Service.ResponseDTO.UserResponseDTO;
import com.CCS.Service.Service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<UserResponseDTO>>>
    getAllUsers() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Users fetched successfully",
                        userService.getAllUsers(),
                        true));
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<UserResponseDTO>>
    getUser(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "User fetched successfully",
                        userService.getUser(id),
                        true));
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<UserResponseDTO>>
    newUser(
            @Valid @RequestBody
            UserRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "User created successfully",
                        userService.newUser(dto),
                        true),
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<UserResponseDTO>>
    updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody
            UserRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "User updated successfully",
                        userService.updateUser(id, dto),
                        true));
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteUser(@PathVariable UUID id) {

        userService.deleteUser(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "User deleted successfully",
                        null,
                        true));
    }
}