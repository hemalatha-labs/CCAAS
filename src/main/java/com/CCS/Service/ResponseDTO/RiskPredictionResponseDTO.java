package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.RiskLevel;

import lombok.Data;

@Data
public class RiskPredictionResponseDTO {

    private UUID predictionId;

    private Double riskScore;

    private RiskLevel riskLevel;

    private String reason;

    private LocalDateTime predictedAt;

    private UUID modelId;

    private UUID resourceId;
}