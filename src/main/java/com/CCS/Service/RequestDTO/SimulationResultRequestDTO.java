package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SimulationResultRequestDTO {

    @NotNull(message = "Risk score is required")
    private Double riskScore;

    @NotNull(message = "Compliance score is required")
    private Double complianceScore;

    private String impact;

    private String recommendation;

    @NotNull(message = "Simulation ID is required")
    private UUID simulationId;
}