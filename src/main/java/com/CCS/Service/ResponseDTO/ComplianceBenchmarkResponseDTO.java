package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ComplianceBenchmarkResponseDTO {

    private UUID benchmarkId;

    private String benchmarkName;

    private String benchmarkVersion;

    private String description;

    private String provider;

    private Boolean active;

    private LocalDateTime createdAt;
}