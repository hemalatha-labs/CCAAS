package com.CCS.Service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ScanReportMapper;
import com.CCS.Service.Repo.ComplianceScanRepo;
import com.CCS.Service.Repo.ScanReportRepo;
import com.CCS.Service.Repo.ViolationRepo;
import com.CCS.Service.RequestDTO.ScanReportRequestDTO;
import com.CCS.Service.ResponseDTO.ScanReportResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ComplianceScan;
import com.CCS.Service.model.ScanReport;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScanReportService {

    @Autowired
    private ScanReportRepo scanReportRepo;

    @Autowired
    private ComplianceScanRepo complianceScanRepo;

    @Autowired
    private ViolationRepo violationRepo;

    @Autowired
    private ScanReportMapper scanReportMapper;


    // GET ALL
    public List<ScanReportResponseDTO>
    getAllReports() {

        return scanReportRepo.findAll()
                .stream()
                .map(scanReportMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ScanReportResponseDTO
    getReport(UUID id) {

        ScanReport report =
                scanReportRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Scan report not found with id: "
                                                + id));

        return scanReportMapper
                .toResponseDTO(report);
    }


    // GENERATE REPORT
    public ScanReportResponseDTO
    generateReport(
            ScanReportRequestDTO dto) {

        ComplianceScan scan =
                complianceScanRepo.findById(
                        dto.getScanId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance scan not found with id: "
                                                + dto.getScanId()));

        ScanReport report =
                new ScanReport();

        report.setReportName(
                "Compliance Scan Report");

        report.setGeneratedAt(
                LocalDateTime.now());

        report.setTotalResources(
                scan.getTotalResources());

        report.setCompliantResources(
                scan.getCompliantResources());

        report.setNonCompliantResources(
                scan.getNonCompliantResources());

        report.setComplianceScore(
                scan.getComplianceScore());

        report.setTotalViolations(
                violationRepo
                        .findByComplianceScanScanId(
                                scan.getScanId())
                        .size());

        report.setComplianceScan(scan);

        ScanReport saved =
                scanReportRepo.save(report);

        return scanReportMapper
                .toResponseDTO(saved);
    }


    // DELETE
    public void deleteReport(UUID id) {

        ScanReport report =
                scanReportRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Scan report not found with id: "
                                                + id));

        scanReportRepo.delete(report);
    }
}