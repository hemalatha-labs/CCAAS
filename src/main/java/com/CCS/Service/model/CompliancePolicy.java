package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.PolicyStatus;

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
@Table(name = "compliance_policy")
@Data
public class CompliancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID policyId;

    private String policyName;

    private String description;

    private String version;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "framework_id")
    private ComplianceFramework complianceFramework;
}