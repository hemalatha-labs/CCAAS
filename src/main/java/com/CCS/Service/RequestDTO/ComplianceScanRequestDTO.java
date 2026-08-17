package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ComplianceScanRequestDTO {

    @NotNull(message = "Schedule ID is required")
    private UUID scheduleId;
}