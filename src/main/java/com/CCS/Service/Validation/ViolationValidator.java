package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ViolationRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class ViolationValidator {

    public void validate(
            ViolationRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Violation request cannot be null");
        }

        if (dto.getTitle() == null ||
                dto.getTitle().isBlank()) {

            throw new BadRequestException(
                    "Violation title is required");
        }

        if (dto.getDescription() == null ||
                dto.getDescription().isBlank()) {

            throw new BadRequestException(
                    "Violation description is required");
        }

        if (dto.getSeverity() == null) {

            throw new BadRequestException(
                    "Violation severity is required");
        }

        if (dto.getScanId() == null) {

            throw new BadRequestException(
                    "Scan ID is required");
        }

        if (dto.getRuleId() == null) {

            throw new BadRequestException(
                    "Rule ID is required");
        }

        if (dto.getResourceId() == null) {

            throw new BadRequestException(
                    "Resource ID is required");
        }
    }
}