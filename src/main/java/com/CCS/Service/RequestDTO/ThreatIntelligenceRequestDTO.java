package com.CCS.Service.RequestDTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ThreatIntelligenceRequestDTO {

    @NotBlank(message = "Threat name is required")
    private String threatName;

    @NotBlank(message = "Threat type is required")
    private String threatType;

    private String description;

    private String severity;

    private String source;

    private Boolean active;
}