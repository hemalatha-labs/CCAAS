package com.CCS.Service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Enumuration.ScanStatus;
import com.CCS.Service.Mapper.ComplianceScanMapper;
import com.CCS.Service.Repo.ComplianceScanRepo;
import com.CCS.Service.Repo.ScanScheduleRepo;
import com.CCS.Service.RequestDTO.ComplianceScanRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceScanResponseDTO;
import com.CCS.Service.Validation.ComplianceScanValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ComplianceScan;
import com.CCS.Service.model.ScanSchedule;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceScanService {

    @Autowired
    private ComplianceScanRepo complianceScanRepo;

    @Autowired
    private ScanScheduleRepo scanScheduleRepo;

    @Autowired
    private ComplianceScanMapper complianceScanMapper;

    @Autowired
    private ComplianceScanValidator complianceScanValidator;


    // GET ALL
    public List<ComplianceScanResponseDTO>
    getAllComplianceScans() {

        return complianceScanRepo.findAll()
                .stream()
                .map(complianceScanMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ComplianceScanResponseDTO
    getComplianceScan(UUID id) {

        ComplianceScan scan =
                complianceScanRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance scan not found with id: "
                                                + id));

        return complianceScanMapper
                .toResponseDTO(scan);
    }


    // GET BY SCHEDULE
    public List<ComplianceScanResponseDTO>
    getScansBySchedule(UUID scheduleId) {

        scanScheduleRepo.findById(scheduleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Scan schedule not found with id: "
                                        + scheduleId));

        return complianceScanRepo
                .findByScanScheduleScheduleId(
                        scheduleId)
                .stream()
                .map(complianceScanMapper::toResponseDTO)
                .toList();
    }


    // START NEW SCAN
    public ComplianceScanResponseDTO
    newComplianceScan(
            ComplianceScanRequestDTO dto) {

        complianceScanValidator.validate(dto);

        ScanSchedule schedule =
                scanScheduleRepo.findById(
                        dto.getScheduleId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Scan schedule not found with id: "
                                                + dto.getScheduleId()));

        if (!Boolean.TRUE.equals(
                schedule.getEnabled())) {

            throw new IllegalStateException(
                    "Scan schedule is disabled");
        }

        ComplianceScan scan =
                complianceScanMapper.toEntity(dto);

        scan.setScanSchedule(schedule);

        scan.setStartTime(
                LocalDateTime.now());

        scan.setStatus(
                ScanStatus.RUNNING);

        /*
         * Actual cloud resource scanning
         * will be implemented later.
         *
         * For now we create the scan record.
         */

        scan.setEndTime(
                LocalDateTime.now());

        scan.setStatus(
                ScanStatus.COMPLETED);

        ComplianceScan savedScan =
                complianceScanRepo.save(scan);

        return complianceScanMapper
                .toResponseDTO(savedScan);
    }


    // DELETE
    public void deleteComplianceScan(UUID id) {

        ComplianceScan scan =
                complianceScanRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance scan not found with id: "
                                                + id));

        complianceScanRepo.delete(scan);
    }
}