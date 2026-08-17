package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "compliance_score")
@Data
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID scoreId;

    private Double score;

    private Integer totalResources;

    private Integer compliantResources;

    private Integer nonCompliantResources;

    private LocalDateTime calculatedAt;

    @OneToOne
    @JoinColumn(name = "scan_id")
    private ComplianceScan complianceScan;
}