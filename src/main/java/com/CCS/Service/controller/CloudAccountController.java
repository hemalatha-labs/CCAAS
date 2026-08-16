package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.CloudAccountRequestDTO;
import com.CCS.Service.ResponseDTO.CloudAccountResponseDTO;
import com.CCS.Service.Service.CloudAccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cloud-accounts")
@RequiredArgsConstructor
public class CloudAccountController {

    @Autowired
    private CloudAccountService cloudAccountService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<CloudAccountResponseDTO>>>
    getAllCloudAccounts() {

        List<CloudAccountResponseDTO> cloudAccounts =
                cloudAccountService.getAllCloudAccounts();

        ApiResponse<List<CloudAccountResponseDTO>> response =
                new ApiResponse<>(
                        "Cloud accounts fetched successfully",
                        cloudAccounts,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<CloudAccountResponseDTO>>
    getCloudAccount(@PathVariable UUID id) {

        CloudAccountResponseDTO cloudAccount =
                cloudAccountService.getCloudAccount(id);

        ApiResponse<CloudAccountResponseDTO> response =
                new ApiResponse<>(
                        "Cloud account fetched successfully",
                        cloudAccount,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<CloudAccountResponseDTO>>
    newCloudAccount(
            @Valid @RequestBody CloudAccountRequestDTO dto) {

        CloudAccountResponseDTO cloudAccount =
                cloudAccountService.newCloudAccount(dto);

        ApiResponse<CloudAccountResponseDTO> response =
                new ApiResponse<>(
                        "Cloud account created successfully",
                        cloudAccount,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<CloudAccountResponseDTO>>
    updateCloudAccount(
            @PathVariable UUID id,
            @Valid @RequestBody CloudAccountRequestDTO dto) {

        CloudAccountResponseDTO cloudAccount =
                cloudAccountService.updateCloudAccount(
                        id, dto);

        ApiResponse<CloudAccountResponseDTO> response =
                new ApiResponse<>(
                        "Cloud account updated successfully",
                        cloudAccount,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteCloudAccount(@PathVariable UUID id) {

        cloudAccountService.deleteCloudAccount(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Cloud account deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}