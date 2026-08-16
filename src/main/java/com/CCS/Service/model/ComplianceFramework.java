package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "compliance_framework")
@Data
public class ComplianceFramework {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID frameworkId;

    private String frameworkName;

    private String description;

    private String version;

    private String authority;

    private LocalDateTime createdAt;
}