package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.ScanFrequency;

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
@Table(name = "scan_schedule")
@Data
public class ScanSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID scheduleId;

    private String scheduleName;

    @Enumerated(EnumType.STRING)
    private ScanFrequency frequency;

    private LocalDateTime nextRun;

    private LocalDateTime lastRun;

    private Boolean enabled;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "cloud_account_id")
    private CloudAccount cloudAccount;
}