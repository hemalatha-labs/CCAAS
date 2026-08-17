package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.IndustryType;
import com.CCS.Service.Enumuration.SubscriptionPlan;
import com.CCS.Service.Enumuration.TenantStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tenant")
@Data
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tenantId;

    private String tenantName;

    @Enumerated(EnumType.STRING)
    private IndustryType industry;

    @Enumerated(EnumType.STRING)
    private SubscriptionPlan subscriptionPlan;

    @Enumerated(EnumType.STRING)
    private TenantStatus status;

    private LocalDateTime createdAt;
}