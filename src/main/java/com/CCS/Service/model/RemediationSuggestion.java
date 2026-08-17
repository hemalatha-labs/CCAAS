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
@Table(name = "remediation_suggestion")
@Data
public class RemediationSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID suggestionId;

    private String title;

    private String description;

    private String priority;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "violation_id")
    private Violation violation;
}