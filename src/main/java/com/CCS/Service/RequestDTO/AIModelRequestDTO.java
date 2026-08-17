package com.CCS.Service.RequestDTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AIModelRequestDTO {

    @NotBlank(message = "Model name is required")
    private String modelName;

    @NotBlank(message = "Version is required")
    private String version;

    @NotBlank(message = "Model type is required")
    private String modelType;

    private String provider;

    private Boolean active;
}