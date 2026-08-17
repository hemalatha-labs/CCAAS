package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.ScanStatus;

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
@Table(name = "compliance_scan")
@Data
public class ComplianceScan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID scanId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ScanStatus status;

    private Integer totalResources;

    private Integer compliantResources;

    private Integer nonCompliantResources;

    private Double complianceScore;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private ScanSchedule scanSchedule;
}