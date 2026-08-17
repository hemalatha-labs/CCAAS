package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RemediationScriptRequestDTO {

    @NotBlank(message = "Script name is required")
    private String scriptName;

    @NotBlank(message = "Script type is required")
    private String scriptType;

    private String description;

    @NotBlank(message = "Script content is required")
    private String scriptContent;

    private Boolean active;

    @NotNull(message = "Suggestion ID is required")
    private UUID suggestionId;
}