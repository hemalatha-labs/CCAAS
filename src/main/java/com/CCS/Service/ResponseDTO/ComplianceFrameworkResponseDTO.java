package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ComplianceFrameworkResponseDTO {

    private UUID frameworkId;

    private String frameworkName;

    private String description;

    private String version;

    private String authority;

    private LocalDateTime createdAt;
}