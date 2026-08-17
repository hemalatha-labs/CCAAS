package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class RemediationSuggestionResponseDTO {

    private UUID suggestionId;

    private String title;

    private String description;

    private String priority;

    private LocalDateTime createdAt;

    private UUID violationId;
}