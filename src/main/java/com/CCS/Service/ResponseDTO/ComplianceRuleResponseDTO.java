package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.RuleStatus;

import lombok.Data;

@Data
public class ComplianceRuleResponseDTO {

    private UUID ruleId;

    private String ruleName;

    private String description;

    private String ruleExpression;

    private String severity;

    private RuleStatus status;

    private LocalDateTime createdAt;

    private UUID policyId;
}