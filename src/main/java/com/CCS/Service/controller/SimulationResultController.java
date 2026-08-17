package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.SimulationResultRequestDTO;
import com.CCS.Service.ResponseDTO.SimulationResultResponseDTO;
import com.CCS.Service.Service.SimulationResultService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/simulation-results")
@RequiredArgsConstructor
public class SimulationResultController {

    @Autowired
    private SimulationResultService simulationResultService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<SimulationResultResponseDTO>>>
    getAllResults() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulation results fetched successfully",
                        simulationResultService.getAllResults(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<SimulationResultResponseDTO>>
    getResult(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulation result fetched successfully",
                        simulationResultService.getResult(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<SimulationResultResponseDTO>>
    newResult(
            @Valid @RequestBody
            SimulationResultRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Simulation result created successfully",
                        simulationResultService.newResult(dto),
                        true),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteResult(@PathVariable UUID id) {

        simulationResultService.deleteResult(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulation result deleted successfully",
                        null,
                        true));
    }
}