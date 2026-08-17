package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ComplianceRuleRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class ComplianceRuleValidator {

    public void validate(
            ComplianceRuleRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Compliance rule request cannot be null");
        }

        if (dto.getRuleName() == null ||
                dto.getRuleName().isBlank()) {

            throw new BadRequestException(
                    "Rule name is required");
        }

        if (dto.getDescription() == null ||
                dto.getDescription().isBlank()) {

            throw new BadRequestException(
                    "Rule description is required");
        }

        if (dto.getRuleExpression() == null ||
                dto.getRuleExpression().isBlank()) {

            throw new BadRequestException(
                    "Rule expression is required");
        }

        if (dto.getSeverity() == null ||
                dto.getSeverity().isBlank()) {

            throw new BadRequestException(
                    "Severity is required");
        }

        if (dto.getPolicyId() == null) {

            throw new BadRequestException(
                    "Policy ID is required");
        }
    }
}