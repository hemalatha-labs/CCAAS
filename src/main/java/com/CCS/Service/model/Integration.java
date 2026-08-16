package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.IntegrationStatus;
import com.CCS.Service.Enumuration.IntegrationType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "integration")
@Data
public class Integration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID integrationId;

    private String integrationName;

    @Enumerated(EnumType.STRING)
    private IntegrationType integrationType;

    @Enumerated(EnumType.STRING)
    private IntegrationStatus status;

    private String credentials;

    private LocalDateTime createdAt;
}