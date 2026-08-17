package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AIModelResponseDTO {

    private UUID modelId;

    private String modelName;

    private String version;

    private String modelType;

    private String provider;

    private Boolean active;

    private LocalDateTime createdAt;
}