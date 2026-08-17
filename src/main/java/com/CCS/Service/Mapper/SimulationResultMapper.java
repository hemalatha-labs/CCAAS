package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.SimulationResultRequestDTO;
import com.CCS.Service.ResponseDTO.SimulationResultResponseDTO;
import com.CCS.Service.model.SimulationResult;

@Component
public class SimulationResultMapper {

    public SimulationResult toEntity(
            SimulationResultRequestDTO dto) {

        SimulationResult result =
                new SimulationResult();

        result.setRiskScore(
                dto.getRiskScore());

        result.setComplianceScore(
                dto.getComplianceScore());

        result.setImpact(
                dto.getImpact());

        result.setRecommendation(
                dto.getRecommendation());

        result.setGeneratedAt(
                LocalDateTime.now());

        return result;
    }


    public SimulationResultResponseDTO
    toResponseDTO(
            SimulationResult result) {

        SimulationResultResponseDTO dto =
                new SimulationResultResponseDTO();

        dto.setResultId(
                result.getResultId());

        dto.setRiskScore(
                result.getRiskScore());

        dto.setComplianceScore(
                result.getComplianceScore());

        dto.setImpact(
                result.getImpact());

        dto.setRecommendation(
                result.getRecommendation());

        dto.setGeneratedAt(
                result.getGeneratedAt());

        if (result.getSimulation() != null) {

            dto.setSimulationId(
                    result.getSimulation()
                            .getSimulationId());
        }

        return dto;
    }
}