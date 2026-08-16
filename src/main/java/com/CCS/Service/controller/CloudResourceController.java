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
import com.CCS.Service.RequestDTO.CloudResourceRequestDTO;
import com.CCS.Service.ResponseDTO.CloudResourceResponseDTO;
import com.CCS.Service.Service.CloudResourceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cloud-resources")
@RequiredArgsConstructor
public class CloudResourceController {

    @Autowired
    private CloudResourceService cloudResourceService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<CloudResourceResponseDTO>>>
    getAllCloudResources() {

        List<CloudResourceResponseDTO> resources =
                cloudResourceService
                        .getAllCloudResources();

        ApiResponse<List<CloudResourceResponseDTO>> response =
                new ApiResponse<>(
                        "Cloud resources fetched successfully",
                        resources,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<CloudResourceResponseDTO>>
    getCloudResource(
            @PathVariable UUID id) {

        CloudResourceResponseDTO resource =
                cloudResourceService
                        .getCloudResource(id);

        ApiResponse<CloudResourceResponseDTO> response =
                new ApiResponse<>(
                        "Cloud resource fetched successfully",
                        resource,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY CLOUD ACCOUNT
    @GetMapping("/account/{cloudAccountId}")
    public ResponseEntity<
            ApiResponse<List<CloudResourceResponseDTO>>>
    getResourcesByCloudAccount(
            @PathVariable UUID cloudAccountId) {

        List<CloudResourceResponseDTO> resources =
                cloudResourceService
                        .getResourcesByCloudAccount(
                                cloudAccountId);

        ApiResponse<List<CloudResourceResponseDTO>> response =
                new ApiResponse<>(
                        "Cloud resources fetched successfully",
                        resources,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<CloudResourceResponseDTO>>
    newCloudResource(
            @Valid @RequestBody
            CloudResourceRequestDTO dto) {

        CloudResourceResponseDTO resource =
                cloudResourceService
                        .newCloudResource(dto);

        ApiResponse<CloudResourceResponseDTO> response =
                new ApiResponse<>(
                        "Cloud resource created successfully",
                        resource,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<CloudResourceResponseDTO>>
    updateCloudResource(
            @PathVariable UUID id,
            @Valid @RequestBody
            CloudResourceRequestDTO dto) {

        CloudResourceResponseDTO resource =
                cloudResourceService
                        .updateCloudResource(id, dto);

        ApiResponse<CloudResourceResponseDTO> response =
                new ApiResponse<>(
                        "Cloud resource updated successfully",
                        resource,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteCloudResource(
            @PathVariable UUID id) {

        cloudResourceService
                .deleteCloudResource(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Cloud resource deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}