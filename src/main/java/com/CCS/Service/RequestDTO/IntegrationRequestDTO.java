package com.CCS.Service.RequestDTO;

import com.CCS.Service.Enumuration.IntegrationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class IntegrationRequestDTO {

    @NotBlank(message = "Integration name is required")
    private String integrationName;

    @NotNull(message = "Integration type is required")
    private IntegrationType integrationType;

    @NotBlank(message = "Credentials are required")
    private String credentials;
}