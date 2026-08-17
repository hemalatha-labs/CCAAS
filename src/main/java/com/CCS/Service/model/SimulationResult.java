package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "simulation_result")
@Data
public class SimulationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID resultId;

    private Double riskScore;

    private Double complianceScore;

    private String impact;

    private String recommendation;

    private LocalDateTime generatedAt;

    @ManyToOne
    @JoinColumn(name = "simulation_id")
    private Simulation simulation;
}