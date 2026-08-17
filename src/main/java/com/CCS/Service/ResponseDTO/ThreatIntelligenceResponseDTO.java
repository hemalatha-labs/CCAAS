package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ThreatIntelligenceResponseDTO {

    private UUID threatId;

    private String threatName;

    private String threatType;

    private String description;

    private String severity;

    private String source;

    private Boolean active;

    private LocalDateTime detectedAt;
}