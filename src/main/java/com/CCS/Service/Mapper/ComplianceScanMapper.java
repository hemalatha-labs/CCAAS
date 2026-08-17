package com.CCS.Service.Mapper;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ComplianceScanRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceScanResponseDTO;
import com.CCS.Service.model.ComplianceScan;

@Component
public class ComplianceScanMapper {

    public ComplianceScan toEntity(
            ComplianceScanRequestDTO dto) {

        ComplianceScan scan =
                new ComplianceScan();

        scan.setTotalResources(0);

        scan.setCompliantResources(0);

        scan.setNonCompliantResources(0);

        scan.setComplianceScore(0.0);

        return scan;
    }


    public ComplianceScanResponseDTO toResponseDTO(
            ComplianceScan scan) {

        ComplianceScanResponseDTO dto =
                new ComplianceScanResponseDTO();

        dto.setScanId(
                scan.getScanId());

        dto.setStartTime(
                scan.getStartTime());

        dto.setEndTime(
                scan.getEndTime());

        dto.setStatus(
                scan.getStatus());

        dto.setTotalResources(
                scan.getTotalResources());

        dto.setCompliantResources(
                scan.getCompliantResources());

        dto.setNonCompliantResources(
                scan.getNonCompliantResources());

        dto.setComplianceScore(
                scan.getComplianceScore());

        dto.setErrorMessage(
                scan.getErrorMessage());

        if (scan.getScanSchedule() != null) {

            dto.setScheduleId(
                    scan.getScanSchedule()
                            .getScheduleId());
        }

        return dto;
    }
}