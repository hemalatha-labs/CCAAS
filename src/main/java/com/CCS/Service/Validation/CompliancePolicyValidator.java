package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.CompliancePolicyRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class CompliancePolicyValidator {

    public void validate(
            CompliancePolicyRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Compliance policy request cannot be null");
        }

        if (dto.getPolicyName() == null ||
                dto.getPolicyName().isBlank()) {

            throw new BadRequestException(
                    "Policy name is required");
        }

        if (dto.getDescription() == null ||
                dto.getDescription().isBlank()) {

            throw new BadRequestException(
                    "Policy description is required");
        }

        if (dto.getVersion() == null ||
                dto.getVersion().isBlank()) {

            throw new BadRequestException(
                    "Policy version is required");
        }

        if (dto.getFrameworkId() == null) {

            throw new BadRequestException(
                    "Framework ID is required");
        }
    }
}