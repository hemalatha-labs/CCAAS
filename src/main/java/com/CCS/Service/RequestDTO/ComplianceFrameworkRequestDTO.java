package com.CCS.Service.RequestDTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ComplianceFrameworkRequestDTO {

    @NotBlank(message = "Framework name is required")
    private String frameworkName;

    @NotBlank(message = "Framework description is required")
    private String description;

    @NotBlank(message = "Framework version is required")
    private String version;

    @NotBlank(message = "Authority is required")
    private String authority;
}