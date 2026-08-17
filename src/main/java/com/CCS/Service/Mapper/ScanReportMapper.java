package com.CCS.Service.Mapper;

import org.springframework.stereotype.Component;

import com.CCS.Service.ResponseDTO.ScanReportResponseDTO;
import com.CCS.Service.model.ScanReport;

@Component
public class ScanReportMapper {

    public ScanReportResponseDTO toResponseDTO(
            ScanReport report) {

        ScanReportResponseDTO dto =
                new ScanReportResponseDTO();

        dto.setReportId(
                report.getReportId());

        dto.setReportName(
                report.getReportName());

        dto.setGeneratedAt(
                report.getGeneratedAt());

        dto.setTotalResources(
                report.getTotalResources());

        dto.setCompliantResources(
                report.getCompliantResources());

        dto.setNonCompliantResources(
                report.getNonCompliantResources());

        dto.setComplianceScore(
                report.getComplianceScore());

        dto.setTotalViolations(
                report.getTotalViolations());

        if (report.getComplianceScan() != null) {

            dto.setScanId(
                    report.getComplianceScan()
                            .getScanId());
        }

        return dto;
    }
}