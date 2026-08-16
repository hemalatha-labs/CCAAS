package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.IntegrationStatus;
import com.CCS.Service.Enumuration.IntegrationType;

import lombok.Data;

@Data
public class IntegrationResponseDTO {

    private UUID integrationId;

    private String integrationName;

    private IntegrationType integrationType;

    private IntegrationStatus status;

    private LocalDateTime createdAt;
}