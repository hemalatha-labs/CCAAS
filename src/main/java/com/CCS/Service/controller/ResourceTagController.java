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
import com.CCS.Service.RequestDTO.ResourceTagRequestDTO;
import com.CCS.Service.ResponseDTO.ResourceTagResponseDTO;
import com.CCS.Service.Service.ResourceTagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/resource-tags")
@RequiredArgsConstructor
public class ResourceTagController {

    @Autowired
    private ResourceTagService resourceTagService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ResourceTagResponseDTO>>>
    getAllResourceTags() {

        List<ResourceTagResponseDTO> tags =
                resourceTagService.getAllResourceTags();

        ApiResponse<List<ResourceTagResponseDTO>> response =
                new ApiResponse<>(
                        "Resource tags fetched successfully",
                        tags,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ResourceTagResponseDTO>>
    getResourceTag(@PathVariable UUID id) {

        ResourceTagResponseDTO tag =
                resourceTagService.getResourceTag(id);

        ApiResponse<ResourceTagResponseDTO> response =
                new ApiResponse<>(
                        "Resource tag fetched successfully",
                        tag,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY CLOUD RESOURCE
    @GetMapping("/resource/{cloudResourceId}")
    public ResponseEntity<
            ApiResponse<List<ResourceTagResponseDTO>>>
    getTagsByCloudResource(
            @PathVariable UUID cloudResourceId) {

        List<ResourceTagResponseDTO> tags =
                resourceTagService
                        .getTagsByCloudResource(
                                cloudResourceId);

        ApiResponse<List<ResourceTagResponseDTO>> response =
                new ApiResponse<>(
                        "Resource tags fetched successfully",
                        tags,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ResourceTagResponseDTO>>
    newResourceTag(
            @Valid @RequestBody
            ResourceTagRequestDTO dto) {

        ResourceTagResponseDTO tag =
                resourceTagService
                        .newResourceTag(dto);

        ApiResponse<ResourceTagResponseDTO> response =
                new ApiResponse<>(
                        "Resource tag created successfully",
                        tag,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<ResourceTagResponseDTO>>
    updateResourceTag(
            @PathVariable UUID id,
            @Valid @RequestBody
            ResourceTagRequestDTO dto) {

        ResourceTagResponseDTO tag =
                resourceTagService.updateResourceTag(
                        id, dto);

        ApiResponse<ResourceTagResponseDTO> response =
                new ApiResponse<>(
                        "Resource tag updated successfully",
                        tag,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteResourceTag(@PathVariable UUID id) {

        resourceTagService.deleteResourceTag(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Resource tag deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}