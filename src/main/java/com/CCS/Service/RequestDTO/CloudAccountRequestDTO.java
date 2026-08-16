package com.CCS.Service.RequestDTO;

import com.CCS.Service.Enumuration.CloudProvider;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CloudAccountRequestDTO {

    @NotBlank(message = "Account name is required")
    private String accountName;

    @NotBlank(message = "Account identifier is required")
    private String accountIdentifier;

    @NotNull(message = "Cloud provider is required")
    private CloudProvider provider;

    @NotBlank(message = "Region is required")
    private String region;
}