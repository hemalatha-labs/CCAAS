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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.RemediationSuggestionRequestDTO;
import com.CCS.Service.ResponseDTO.RemediationSuggestionResponseDTO;
import com.CCS.Service.Service.RemediationSuggestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/remediation-suggestions")
@RequiredArgsConstructor
public class RemediationSuggestionController {

    @Autowired
    private RemediationSuggestionService
            remediationSuggestionService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<
                List<RemediationSuggestionResponseDTO>>>
    getAllSuggestions() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation suggestions fetched successfully",
                        remediationSuggestionService
                                .getAllSuggestions(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<RemediationSuggestionResponseDTO>>
    getSuggestion(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation suggestion fetched successfully",
                        remediationSuggestionService
                                .getSuggestion(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<RemediationSuggestionResponseDTO>>
    newSuggestion(
            @Valid @RequestBody
            RemediationSuggestionRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Remediation suggestion created successfully",
                        remediationSuggestionService
                                .newSuggestion(dto),
                        true),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteSuggestion(@PathVariable UUID id) {

        remediationSuggestionService
                .deleteSuggestion(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Remediation suggestion deleted successfully",
                        null,
                        true));
    }
}