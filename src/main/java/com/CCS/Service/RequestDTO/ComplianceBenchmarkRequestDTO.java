package com.CCS.Service.RequestDTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ComplianceBenchmarkRequestDTO {

    @NotBlank(message = "Benchmark name is required")
    private String benchmarkName;

    private String benchmarkVersion;

    private String description;

    private String provider;

    private Boolean active;
}