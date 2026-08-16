package com.CCS.Service.RequestDTO;

import java.util.UUID;

import com.CCS.Service.Enumuration.CloudResourceType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CloudResourceRequestDTO {

    @NotBlank(message = "Resource name is required")
    private String resourceName;

    @NotBlank(message = "Resource identifier is required")
    private String resourceIdentifier;

    @NotNull(message = "Resource type is required")
    private CloudResourceType resourceType;

    @NotBlank(message = "Region is required")
    private String region;

    @NotNull(message = "Cloud account ID is required")
    private UUID cloudAccountId;
}