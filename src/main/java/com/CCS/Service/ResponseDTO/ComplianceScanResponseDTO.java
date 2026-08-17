package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.ScanStatus;

import lombok.Data;

@Data
public class ComplianceScanResponseDTO {

    private UUID scanId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private ScanStatus status;

    private Integer totalResources;

    private Integer compliantResources;

    private Integer nonCompliantResources;

    private Double complianceScore;

    private String errorMessage;

    private UUID scheduleId;
}