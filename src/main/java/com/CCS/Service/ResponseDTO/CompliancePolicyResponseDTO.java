package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.PolicyStatus;

import lombok.Data;

@Data
public class CompliancePolicyResponseDTO {

    private UUID policyId;

    private String policyName;

    private String description;

    private String version;

    private PolicyStatus status;

    private LocalDateTime createdAt;

    private UUID frameworkId;
}