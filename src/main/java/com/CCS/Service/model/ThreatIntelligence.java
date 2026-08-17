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
@Table(name = "threat_intelligence")
@Data
public class ThreatIntelligence {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID threatId;

    private String threatName;

    private String threatType;

    private String description;

    private String severity;

    private String source;

    private Boolean active;

    private LocalDateTime detectedAt;
}