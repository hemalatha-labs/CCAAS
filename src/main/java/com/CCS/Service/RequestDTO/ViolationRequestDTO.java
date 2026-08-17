package com.CCS.Service.RequestDTO;

import java.util.UUID;

import com.CCS.Service.Enumuration.ViolationSeverity;
import com.CCS.Service.Enumuration.ViolationStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ViolationRequestDTO {

    @NotBlank(message = "Violation title is required")
    private String title;

    @NotBlank(message = "Violation description is required")
    private String description;

    @NotNull(message = "Severity is required")
    private ViolationSeverity severity;

    private ViolationStatus status;

    @NotNull(message = "Scan ID is required")
    private UUID scanId;

    @NotNull(message = "Rule ID is required")
    private UUID ruleId;

    @NotNull(message = "Resource ID is required")
    private UUID resourceId;
}