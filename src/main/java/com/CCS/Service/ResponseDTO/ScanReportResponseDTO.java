package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ScanReportResponseDTO {

    private UUID reportId;

    private String reportName;

    private LocalDateTime generatedAt;

    private Integer totalResources;

    private Integer compliantResources;

    private Integer nonCompliantResources;

    private Double complianceScore;

    private Integer totalViolations;

    private UUID scanId;
}