package com.CCS.Service.Mapper;

import org.springframework.stereotype.Component;

import com.CCS.Service.ResponseDTO.ComplianceScoreResponseDTO;
import com.CCS.Service.model.ComplianceScore;

@Component
public class ComplianceScoreMapper {

    public ComplianceScoreResponseDTO toResponseDTO(
            ComplianceScore score) {

        ComplianceScoreResponseDTO dto =
                new ComplianceScoreResponseDTO();

        dto.setScoreId(
                score.getScoreId());

        dto.setScore(
                score.getScore());

        dto.setTotalResources(
                score.getTotalResources());

        dto.setCompliantResources(
                score.getCompliantResources());

        dto.setNonCompliantResources(
                score.getNonCompliantResources());

        dto.setCalculatedAt(
                score.getCalculatedAt());

        if (score.getComplianceScan() != null) {

            dto.setScanId(
                    score.getComplianceScan()
                            .getScanId());
        }

        return dto;
    }
}