package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.ViolationSeverity;
import com.CCS.Service.Enumuration.ViolationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data

public class ViolationResponseDTO {

    private UUID violationId;

    private String title;

    private String description;

    private ViolationSeverity severity;

    private ViolationStatus status;

    private LocalDateTime detectedAt;

    private LocalDateTime resolvedAt;

    private UUID scanId;

    private UUID ruleId;

    private UUID resourceId;
}