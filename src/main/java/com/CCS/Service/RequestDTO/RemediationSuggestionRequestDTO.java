package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RemediationSuggestionRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String priority;

    @NotNull(message = "Violation ID is required")
    private UUID violationId;
}