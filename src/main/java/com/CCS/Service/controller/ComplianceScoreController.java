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
import com.CCS.Service.RequestDTO.ComplianceScoreRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceScoreResponseDTO;
import com.CCS.Service.Service.ComplianceScoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compliance-scores")
@RequiredArgsConstructor
public class ComplianceScoreController {

    @Autowired
    private ComplianceScoreService complianceScoreService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<ComplianceScoreResponseDTO>>>
    getAllScores() {

        List<ComplianceScoreResponseDTO> scores =
                complianceScoreService.getAllScores();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance scores fetched successfully",
                        scores,
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<ComplianceScoreResponseDTO>>
    getScore(@PathVariable UUID id) {

        ComplianceScoreResponseDTO score =
                complianceScoreService.getScore(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance score fetched successfully",
                        score,
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<ComplianceScoreResponseDTO>>
    calculateScore(
            @Valid @RequestBody
            ComplianceScoreRequestDTO dto) {

        ComplianceScoreResponseDTO score =
                complianceScoreService
                        .calculateScore(dto);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Compliance score calculated successfully",
                        score,
                        true),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteScore(@PathVariable UUID id) {

        complianceScoreService.deleteScore(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Compliance score deleted successfully",
                        null,
                        true));
    }
}