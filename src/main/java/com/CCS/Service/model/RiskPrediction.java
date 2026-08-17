package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.RiskLevel;

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
@Table(name = "risk_prediction")
@Data
public class RiskPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID predictionId;

    private Double riskScore;

    @Enumerated(EnumType.STRING)
    private RiskLevel riskLevel;

    private String reason;

    private LocalDateTime predictedAt;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private AIModel aiModel;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private CloudResource cloudResource;
}