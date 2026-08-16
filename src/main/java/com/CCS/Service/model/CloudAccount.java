package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.CloudAccountStatus;
import com.CCS.Service.Enumuration.CloudProvider;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cloud_account")
@Data
public class CloudAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cloudAccountId;

    private String accountName;

    private String accountIdentifier;

    @Enumerated(EnumType.STRING)
    private CloudProvider provider;

    private String region;

    @Enumerated(EnumType.STRING)
    private CloudAccountStatus status;

    private LocalDateTime createdAt;
}