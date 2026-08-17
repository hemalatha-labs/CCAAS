package com.CCS.Service.Mapper;

import org.springframework.stereotype.Component;

import com.CCS.Service.ResponseDTO.RiskPredictionResponseDTO;
import com.CCS.Service.model.RiskPrediction;

@Component
public class RiskPredictionMapper {

    public RiskPredictionResponseDTO toResponseDTO(
            RiskPrediction prediction) {

        RiskPredictionResponseDTO dto =
                new RiskPredictionResponseDTO();

        dto.setPredictionId(
                prediction.getPredictionId());

        dto.setRiskScore(
                prediction.getRiskScore());

        dto.setRiskLevel(
                prediction.getRiskLevel());

        dto.setReason(
                prediction.getReason());

        dto.setPredictedAt(
                prediction.getPredictedAt());

        if (prediction.getAiModel() != null) {

            dto.setModelId(
                    prediction.getAiModel()
                            .getModelId());
        }

        if (prediction.getCloudResource() != null) {

            dto.setResourceId(
                    prediction.getCloudResource()
                            .getCloudResourceId());
        }

        return dto;
    }
}