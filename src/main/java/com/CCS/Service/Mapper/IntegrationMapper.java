package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.IntegrationStatus;
import com.CCS.Service.RequestDTO.IntegrationRequestDTO;
import com.CCS.Service.ResponseDTO.IntegrationResponseDTO;
import com.CCS.Service.model.Integration;

@Component
public class IntegrationMapper {

    public Integration toEntity(
            IntegrationRequestDTO dto) {

        Integration integration = new Integration();

        integration.setIntegrationName(
                dto.getIntegrationName());

        integration.setIntegrationType(
                dto.getIntegrationType());

        integration.setCredentials(
                dto.getCredentials());

        integration.setStatus(
                IntegrationStatus.ACTIVE);

        integration.setCreatedAt(
                LocalDateTime.now());

        return integration;
    }


    public IntegrationResponseDTO toResponseDTO(
            Integration integration) {

        IntegrationResponseDTO dto =
                new IntegrationResponseDTO();

        dto.setIntegrationId(
                integration.getIntegrationId());

        dto.setIntegrationName(
                integration.getIntegrationName());

        dto.setIntegrationType(
                integration.getIntegrationType());

        dto.setStatus(
                integration.getStatus());

        dto.setCreatedAt(
                integration.getCreatedAt());

        return dto;
    }
}