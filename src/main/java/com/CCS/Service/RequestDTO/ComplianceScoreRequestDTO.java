package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ComplianceScoreRequestDTO {

    @NotNull(message = "Scan ID is required")
    private UUID scanId;
}