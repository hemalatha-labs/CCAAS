package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "remediation_script")
@Data
public class RemediationScript {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID scriptId;

    private String scriptName;

    private String scriptType;

    private String description;

    private String scriptContent;

    private Boolean active;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "suggestion_id")
    private RemediationSuggestion suggestion;
}