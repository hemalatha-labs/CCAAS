package com.CCS.Service.RequestDTO;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ResourceTagRequestDTO {

    @NotBlank(message = "Tag key is required")
    private String tagKey;

    @NotBlank(message = "Tag value is required")
    private String tagValue;

    @NotNull(message = "Cloud resource ID is required")
    private UUID cloudResourceId;
}