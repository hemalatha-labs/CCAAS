package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.ViolationSeverity;
import com.CCS.Service.Enumuration.ViolationStatus;

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
@Table(name = "violation")
@Data
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID violationId;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private ViolationSeverity severity;

    @Enumerated(EnumType.STRING)
    private ViolationStatus status;

    private LocalDateTime detectedAt;

    private LocalDateTime resolvedAt;

    @ManyToOne
    @JoinColumn(name = "scan_id")
    private ComplianceScan complianceScan;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private ComplianceRule complianceRule;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private CloudResource cloudResource;


    // Getter and Setter for violationId

    public UUID getViolationId() {
        return violationId;
    }

    public void setViolationId(UUID violationId) {
        this.violationId = violationId;
    }


    // Getter and Setter for title

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // Getter and Setter for description

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Getter and Setter for severity

    public ViolationSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ViolationSeverity severity) {
        this.severity = severity;
    }


    // Getter and Setter for status

    public ViolationStatus getStatus() {
        return status;
    }

    public void setStatus(ViolationStatus status) {
        this.status = status;
    }


    // Getter and Setter for detectedAt

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }


    // Getter and Setter for resolvedAt

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }


    // Getter and Setter for complianceScan

    public ComplianceScan getComplianceScan() {
        return complianceScan;
    }

    public void setComplianceScan(ComplianceScan complianceScan) {
        this.complianceScan = complianceScan;
    }


    // Getter and Setter for complianceRule

    public ComplianceRule getComplianceRule() {
        return complianceRule;
    }

    public void setComplianceRule(ComplianceRule complianceRule) {
        this.complianceRule = complianceRule;
    }


    // Getter and Setter for cloudResource

    public CloudResource getCloudResource() {
        return cloudResource;
    }

    public void setCloudResource(CloudResource cloudResource) {
        this.cloudResource = cloudResource;
    }
}