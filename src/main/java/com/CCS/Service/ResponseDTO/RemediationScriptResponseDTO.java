package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class RemediationScriptResponseDTO {

    private UUID scriptId;

    private String scriptName;

    private String scriptType;

    private String description;

    private String scriptContent;

    private Boolean active;

    private LocalDateTime createdAt;

    private UUID suggestionId;
}