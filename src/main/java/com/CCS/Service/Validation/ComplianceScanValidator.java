package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ComplianceScanRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class ComplianceScanValidator {

    public void validate(
            ComplianceScanRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Compliance scan request cannot be null");
        }

        if (dto.getScheduleId() == null) {

            throw new BadRequestException(
                    "Schedule ID is required");
        }
    }
}