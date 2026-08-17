package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ComplianceRuleRequestDTO {

    @NotBlank(message = "Rule name is required")
    private String ruleName;

    @NotBlank(message = "Rule description is required")
    private String description;

    @NotBlank(message = "Rule expression is required")
    private String ruleExpression;

    @NotBlank(message = "Severity is required")
    private String severity;

    @NotNull(message = "Policy ID is required")
    private UUID policyId;
}