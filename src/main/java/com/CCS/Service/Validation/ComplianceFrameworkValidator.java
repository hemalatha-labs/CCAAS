package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ComplianceFrameworkRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class ComplianceFrameworkValidator {

    public void validate(
            ComplianceFrameworkRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Compliance framework request cannot be null");
        }

        if (dto.getFrameworkName() == null ||
                dto.getFrameworkName().isBlank()) {

            throw new BadRequestException(
                    "Framework name is required");
        }

        if (dto.getDescription() == null ||
                dto.getDescription().isBlank()) {

            throw new BadRequestException(
                    "Framework description is required");
        }

        if (dto.getVersion() == null ||
                dto.getVersion().isBlank()) {

            throw new BadRequestException(
                    "Framework version is required");
        }

        if (dto.getAuthority() == null ||
                dto.getAuthority().isBlank()) {

            throw new BadRequestException(
                    "Authority is required");
        }
    }
}