package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ScanScheduleRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class ScanScheduleValidator {

    public void validate(
            ScanScheduleRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Scan schedule request cannot be null");
        }

        if (dto.getScheduleName() == null ||
                dto.getScheduleName().isBlank()) {

            throw new BadRequestException(
                    "Schedule name is required");
        }

        if (dto.getFrequency() == null) {

            throw new BadRequestException(
                    "Scan frequency is required");
        }

        if (dto.getCloudAccountId() == null) {

            throw new BadRequestException(
                    "Cloud account ID is required");
        }
    }
}