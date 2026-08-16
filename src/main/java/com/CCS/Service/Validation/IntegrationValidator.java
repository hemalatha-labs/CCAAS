package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.IntegrationRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class IntegrationValidator {

    public void validate(IntegrationRequestDTO dto) {

        if (dto == null) {
            throw new BadRequestException(
                    "Integration request cannot be null");
        }

        if (dto.getIntegrationName() == null ||
                dto.getIntegrationName().isBlank()) {

            throw new BadRequestException(
                    "Integration name is required");
        }

        if (dto.getIntegrationType() == null) {

            throw new BadRequestException(
                    "Integration type is required");
        }

        if (dto.getCredentials() == null ||
                dto.getCredentials().isBlank()) {

            throw new BadRequestException(
                    "Credentials are required");
        }
    }
}