package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.CloudResourceStatus;
import com.CCS.Service.Enumuration.CloudResourceType;

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
@Table(name = "cloud_resource")
@Data
public class CloudResource {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cloudResourceId;

    private String resourceName;

    private String resourceIdentifier;

    @Enumerated(EnumType.STRING)
    private CloudResourceType resourceType;

    private String region;

    @Enumerated(EnumType.STRING)
    private CloudResourceStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "cloud_account_id")
    private CloudAccount cloudAccount;
}