package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.CCS.Service.Service.SimulationResultService;
import com.CCS.Service.model.SimulationResult;

@RestController
@RequestMapping("/api/simulationresult")
public class SimulationResultController {

    @Autowired
    private SimulationResultService simulationResultService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<SimulationResult>>> getAllSimulationResults() {

        List<SimulationResult> simulationResults =
                simulationResultService.getAllSimulationResults();

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation Results fetched successfully",
                        simulationResults, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<SimulationResult>>> getSimulationResultById(
            @PathVariable Long id) {

        Optional<SimulationResult> simulationResult =
                simulationResultService.getSimulationResult(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation Result fetched successfully",
                        simulationResult, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SimulationResult>> createSimulationResult(
            @RequestBody SimulationResult simulationResult) {

        SimulationResult createdSimulationResult =
                simulationResultService.newSimulationResult(simulationResult);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation Result created successfully",
                        createdSimulationResult, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SimulationResult>> updateSimulationResult(
            @PathVariable Long id,
            @RequestBody SimulationResult simulationResult) {

        SimulationResult updatedSimulationResult =
                simulationResultService.UpdateSimulationResult(simulationResult);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation Result updated successfully",
                        updatedSimulationResult, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSimulationResult(
            @PathVariable Long id) {

        simulationResultService.deleteSimulationResult(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation Result deleted successfully",
                        null, true));
    }
}