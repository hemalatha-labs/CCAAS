package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ResourceTagRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class ResourceTagValidator {

    public void validate(ResourceTagRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Resource tag request cannot be null");
        }

        if (dto.getTagKey() == null ||
                dto.getTagKey().isBlank()) {

            throw new BadRequestException(
                    "Tag key is required");
        }

        if (dto.getTagValue() == null ||
                dto.getTagValue().isBlank()) {

            throw new BadRequestException(
                    "Tag value is required");
        }

        if (dto.getCloudResourceId() == null) {

            throw new BadRequestException(
                    "Cloud resource ID is required");
        }
    }
}