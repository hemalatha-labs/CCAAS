package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.SimulationRequestDTO;
import com.CCS.Service.ResponseDTO.SimulationResponseDTO;
import com.CCS.Service.Service.SimulationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/simulations")
@RequiredArgsConstructor
public class SimulationController {

    @Autowired
    private SimulationService simulationService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<SimulationResponseDTO>>>
    getAllSimulations() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulations fetched successfully",
                        simulationService.getAllSimulations(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<SimulationResponseDTO>>
    getSimulation(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulation fetched successfully",
                        simulationService.getSimulation(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<SimulationResponseDTO>>
    newSimulation(
            @Valid @RequestBody
            SimulationRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Simulation created successfully",
                        simulationService.newSimulation(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<SimulationResponseDTO>>
    updateSimulation(
            @PathVariable UUID id,
            @Valid @RequestBody
            SimulationRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulation updated successfully",
                        simulationService
                                .updateSimulation(id, dto),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteSimulation(@PathVariable UUID id) {

        simulationService.deleteSimulation(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Simulation deleted successfully",
                        null,
                        true));
    }
}