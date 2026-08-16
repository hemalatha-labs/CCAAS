package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CompliancePolicyRequestDTO {

    @NotBlank(message = "Policy name is required")
    private String policyName;

    @NotBlank(message = "Policy description is required")
    private String description;

    @NotBlank(message = "Policy version is required")
    private String version;

    @NotNull(message = "Framework ID is required")
    private UUID frameworkId;
}