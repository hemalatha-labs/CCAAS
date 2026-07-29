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
import com.CCS.Service.Service.SimulationService;
import com.CCS.Service.model.Simulation;

@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Simulation>>> getAllSimulations() {

        List<Simulation> simulations = simulationService.getAllSimulations();

        return ResponseEntity.ok(
                new ApiResponse<>("Simulations fetched successfully", simulations, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Simulation>>> getSimulationById(@PathVariable Long id) {

        Optional<Simulation> simulation = simulationService.getSimulation(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation fetched successfully", simulation, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Simulation>> createSimulation(
            @RequestBody Simulation simulation) {

        Simulation createdSimulation = simulationService.newSimulation(simulation);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation created successfully", createdSimulation, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Simulation>> updateSimulation(
            @PathVariable Long id,
            @RequestBody Simulation simulation) {

        Simulation updatedSimulation =
                simulationService.UpdateSimulation(simulation);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation updated successfully", updatedSimulation, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSimulation(@PathVariable Long id) {

        simulationService.deleteSimulation(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Simulation deleted successfully", null, true));
    }
}