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
import com.CCS.Service.RequestDTO.IntegrationRequestDTO;
import com.CCS.Service.ResponseDTO.IntegrationResponseDTO;
import com.CCS.Service.Service.IntegrationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/integrations")
@RequiredArgsConstructor
public class IntegrationController {

    @Autowired
    private IntegrationService integrationService;


    // GET ALL
    @GetMapping
    public ResponseEntity<
            ApiResponse<List<IntegrationResponseDTO>>>
    getAllIntegrations() {

        List<IntegrationResponseDTO> integrations =
                integrationService.getAllIntegrations();

        ApiResponse<List<IntegrationResponseDTO>> response =
                new ApiResponse<>(
                        "Integrations fetched successfully",
                        integrations,
                        true);

        return ResponseEntity.ok(response);
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<IntegrationResponseDTO>>
    getIntegration(@PathVariable UUID id) {

        IntegrationResponseDTO integration =
                integrationService.getIntegration(id);

        ApiResponse<IntegrationResponseDTO> response =
                new ApiResponse<>(
                        "Integration fetched successfully",
                        integration,
                        true);

        return ResponseEntity.ok(response);
    }


    // CREATE
    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<IntegrationResponseDTO>>
    newIntegration(
            @Valid @RequestBody IntegrationRequestDTO dto) {

        IntegrationResponseDTO integration =
                integrationService.newIntegration(dto);

        ApiResponse<IntegrationResponseDTO> response =
                new ApiResponse<>(
                        "Integration created successfully",
                        integration,
                        true);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }


    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<
            ApiResponse<IntegrationResponseDTO>>
    updateIntegration(
            @PathVariable UUID id,
            @Valid @RequestBody IntegrationRequestDTO dto) {

        IntegrationResponseDTO integration =
                integrationService.updateIntegration(
                        id, dto);

        ApiResponse<IntegrationResponseDTO> response =
                new ApiResponse<>(
                        "Integration updated successfully",
                        integration,
                        true);

        return ResponseEntity.ok(response);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteIntegration(@PathVariable UUID id) {

        integrationService.deleteIntegration(id);

        ApiResponse<Object> response =
                new ApiResponse<>(
                        "Integration deleted successfully",
                        null,
                        true);

        return ResponseEntity.ok(response);
    }
}