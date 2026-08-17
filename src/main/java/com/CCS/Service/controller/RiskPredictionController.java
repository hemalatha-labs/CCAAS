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
import com.CCS.Service.RequestDTO.RiskPredictionRequestDTO;
import com.CCS.Service.ResponseDTO.RiskPredictionResponseDTO;
import com.CCS.Service.Service.RiskPredictionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/risk-predictions")
@RequiredArgsConstructor
public class RiskPredictionController {

    @Autowired
    private RiskPredictionService riskPredictionService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<RiskPredictionResponseDTO>>>
    getAllPredictions() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Risk predictions fetched successfully",
                        riskPredictionService
                                .getAllPredictions(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<RiskPredictionResponseDTO>>
    getPrediction(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Risk prediction fetched successfully",
                        riskPredictionService
                                .getPrediction(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<RiskPredictionResponseDTO>>
    newPrediction(
            @Valid @RequestBody
            RiskPredictionRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Risk prediction created successfully",
                        riskPredictionService
                                .newPrediction(dto),
                        true),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deletePrediction(@PathVariable UUID id) {

        riskPredictionService
                .deletePrediction(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Risk prediction deleted successfully",
                        null,
                        true));
    }
}