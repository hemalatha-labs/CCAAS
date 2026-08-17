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
@Table(name = "ai_model")
@Data
public class AIModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID modelId;

    private String modelName;

    private String version;

    private String modelType;

    private String provider;

    private Boolean active;

    private LocalDateTime createdAt;
}