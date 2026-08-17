package com.CCS.Service.Mapper;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.ViolationStatus;
import com.CCS.Service.RequestDTO.ViolationRequestDTO;
import com.CCS.Service.ResponseDTO.ViolationResponseDTO;
import com.CCS.Service.model.Violation;

import lombok.Data;

@Data

@Component
public class ViolationMapper {

    public Violation toEntity(
            ViolationRequestDTO dto) {

        Violation violation =
                new Violation();

        violation.setTitle(
                dto.getTitle());

        violation.setDescription(
                dto.getDescription());

        violation.setSeverity(
                dto.getSeverity());

        if (dto.getStatus() == null) {

            violation.setStatus(
                    ViolationStatus.OPEN);

        } else {

            violation.setStatus(
                    dto.getStatus());
        }

        violation.setDetectedAt(
                LocalDateTime.now());

        return violation;
    }


    public ViolationResponseDTO toResponseDTO(
            Violation violation) {

        ViolationResponseDTO dto =
                new ViolationResponseDTO();

        dto.setViolationId(
                violation.getViolationId());

        dto.setTitle(
                violation.getTitle());

        dto.setDescription(
                violation.getDescription());

        dto.setSeverity(
                violation.getSeverity());

        dto.setStatus(
                violation.getStatus());

        dto.setDetectedAt(
                violation.getDetectedAt());

        dto.setResolvedAt(
                violation.getResolvedAt());

        if (violation.getComplianceScan() != null) {

            dto.setScanId(
                    violation.getComplianceScan()
                            .getScanId());
        }

        if (violation.getComplianceRule() != null) {

            dto.setRuleId(
                    violation.getComplianceRule()
                            .getRuleId());
        }

        if (violation.getCloudResource() != null) {

            dto.setResourceId(
                    violation.getCloudResource()
                            .getCloudResourceId());
        }

        return dto;
    }
}