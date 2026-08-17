package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ComplianceScoreResponseDTO {

    private UUID scoreId;

    private Double score;

    private Integer totalResources;

    private Integer compliantResources;

    private Integer nonCompliantResources;

    private LocalDateTime calculatedAt;

    private UUID scanId;
}