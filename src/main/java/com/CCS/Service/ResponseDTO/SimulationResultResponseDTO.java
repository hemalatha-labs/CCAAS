package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class SimulationResultResponseDTO {

    private UUID resultId;

    private Double riskScore;

    private Double complianceScore;

    private String impact;

    private String recommendation;

    private LocalDateTime generatedAt;

    private UUID simulationId;
}