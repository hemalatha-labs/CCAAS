package com.CCS.Service.RequestDTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SimulationRequestDTO {

    @NotBlank(message = "Simulation name is required")
    private String simulationName;

    private String description;

    @NotBlank(message = "Scenario is required")
    private String scenario;
}