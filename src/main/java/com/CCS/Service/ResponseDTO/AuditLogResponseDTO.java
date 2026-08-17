package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.AuditAction;

import lombok.Data;

@Data
public class AuditLogResponseDTO {

    private UUID auditLogId;

    private UUID userId;

    private AuditAction action;

    private String entityName;

    private UUID entityId;

    private String description;

    private LocalDateTime createdAt;
}