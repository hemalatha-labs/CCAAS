package com.CCS.Service.RequestDTO;

import java.util.UUID;

import com.CCS.Service.Enumuration.AuditAction;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AuditLogRequestDTO {

    private UUID userId;

    @NotNull(message = "Action is required")
    private AuditAction action;

    @NotNull(message = "Entity name is required")
    private String entityName;

    private UUID entityId;

    private String description;
}