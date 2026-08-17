package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.RuleStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "compliance_rule")
@Data
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ruleId;

    private String ruleName;

    private String description;

    private String ruleExpression;

    private String severity;

    @Enumerated(EnumType.STRING)
    private RuleStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private CompliancePolicy compliancePolicy;
}