package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.CloudAccountStatus;
import com.CCS.Service.Enumuration.CloudProvider;

import lombok.Data;

@Data
public class CloudAccountResponseDTO {

    private UUID cloudAccountId;

    private String accountName;

    private String accountIdentifier;

    private CloudProvider provider;

    private String region;

    private CloudAccountStatus status;

    private LocalDateTime createdAt;
}