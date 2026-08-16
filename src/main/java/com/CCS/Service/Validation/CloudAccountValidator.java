package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.CloudAccountRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class CloudAccountValidator {

    public void validate(CloudAccountRequestDTO dto) {

        if (dto == null) {
            throw new BadRequestException(
                    "Cloud account request cannot be null");
        }

        if (dto.getAccountName() == null ||
                dto.getAccountName().isBlank()) {

            throw new BadRequestException(
                    "Account name is required");
        }

        if (dto.getAccountIdentifier() == null ||
                dto.getAccountIdentifier().isBlank()) {

            throw new BadRequestException(
                    "Account identifier is required");
        }

        if (dto.getProvider() == null) {

            throw new BadRequestException(
                    "Cloud provider is required");
        }

        if (dto.getRegion() == null ||
                dto.getRegion().isBlank()) {

            throw new BadRequestException(
                    "Region is required");
        }
    }
}