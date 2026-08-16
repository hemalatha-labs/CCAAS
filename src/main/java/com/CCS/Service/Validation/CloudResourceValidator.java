package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.CloudResourceRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class CloudResourceValidator {

    public void validate(
            CloudResourceRequestDTO dto) {

        if (dto == null) {
            throw new BadRequestException(
                    "Cloud resource request cannot be null");
        }

        if (dto.getResourceName() == null ||
                dto.getResourceName().isBlank()) {

            throw new BadRequestException(
                    "Resource name is required");
        }

        if (dto.getResourceIdentifier() == null ||
                dto.getResourceIdentifier().isBlank()) {

            throw new BadRequestException(
                    "Resource identifier is required");
        }

        if (dto.getResourceType() == null) {

            throw new BadRequestException(
                    "Resource type is required");
        }

        if (dto.getRegion() == null ||
                dto.getRegion().isBlank()) {

            throw new BadRequestException(
                    "Region is required");
        }

        if (dto.getCloudAccountId() == null) {

            throw new BadRequestException(
                    "Cloud account ID is required");
        }
    }
}