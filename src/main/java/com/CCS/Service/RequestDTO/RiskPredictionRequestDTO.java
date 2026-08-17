package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RiskPredictionRequestDTO {

    @NotNull(message = "Risk score is required")
    private Double riskScore;

    private String reason;

    @NotNull(message = "AI model ID is required")
    private UUID modelId;

    @NotNull(message = "Resource ID is required")
    private UUID resourceId;
}