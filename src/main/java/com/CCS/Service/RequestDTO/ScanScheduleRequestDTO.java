package com.CCS.Service.RequestDTO;

import java.util.UUID;

import com.CCS.Service.Enumuration.ScanFrequency;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ScanScheduleRequestDTO {

    @NotBlank(message = "Schedule name is required")
    private String scheduleName;

    @NotNull(message = "Scan frequency is required")
    private ScanFrequency frequency;

    @NotNull(message = "Cloud account ID is required")
    private UUID cloudAccountId;

    private Boolean enabled;
}