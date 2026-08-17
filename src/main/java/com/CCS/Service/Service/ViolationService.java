package com.CCS.Service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Enumuration.ViolationStatus;
import com.CCS.Service.Mapper.ViolationMapper;
import com.CCS.Service.Repo.CloudResourceRepo;
import com.CCS.Service.Repo.ComplianceRuleRepo;
import com.CCS.Service.Repo.ComplianceScanRepo;
import com.CCS.Service.Repo.ViolationRepo;
import com.CCS.Service.RequestDTO.ViolationRequestDTO;
import com.CCS.Service.ResponseDTO.ViolationResponseDTO;
import com.CCS.Service.Validation.ViolationValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.CloudResource;
import com.CCS.Service.model.ComplianceRule;
import com.CCS.Service.model.ComplianceScan;
import com.CCS.Service.model.Violation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViolationService {

    @Autowired
    private ViolationRepo violationRepo;

    @Autowired
    private ComplianceScanRepo complianceScanRepo;

    @Autowired
    private ComplianceRuleRepo complianceRuleRepo;

    @Autowired
    private CloudResourceRepo cloudResourceRepo;

    @Autowired
    private ViolationMapper violationMapper;

    @Autowired
    private ViolationValidator violationValidator;


    // GET ALL
    public List<ViolationResponseDTO>
    getAllViolations() {

        return violationRepo.findAll()
                .stream()
                .map(violationMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ViolationResponseDTO
    getViolation(UUID id) {

        Violation violation =
                violationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Violation not found with id: "
                                                + id));

        return violationMapper
                .toResponseDTO(violation);
    }


    // GET BY SCAN
    public List<ViolationResponseDTO>
    getViolationsByScan(UUID scanId) {

        complianceScanRepo.findById(scanId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Compliance scan not found with id: "
                                        + scanId));

        return violationRepo
                .findByComplianceScanScanId(
                        scanId)
                .stream()
                .map(violationMapper::toResponseDTO)
                .toList();
    }


    // CREATE
    public ViolationResponseDTO
    newViolation(
            ViolationRequestDTO dto) {

        violationValidator.validate(dto);

        ComplianceScan scan =
                complianceScanRepo.findById(
                        dto.getScanId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance scan not found with id: "
                                                + dto.getScanId()));

        ComplianceRule rule =
                complianceRuleRepo.findById(
                        dto.getRuleId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance rule not found with id: "
                                                + dto.getRuleId()));

        CloudResource resource =
                cloudResourceRepo.findById(
                        dto.getResourceId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + dto.getResourceId()));

        Violation violation =
                violationMapper.toEntity(dto);

        violation.setComplianceScan(scan);

        violation.setComplianceRule(rule);

        violation.setCloudResource(resource);

        Violation savedViolation =
                violationRepo.save(violation);

        return violationMapper
                .toResponseDTO(savedViolation);
    }


    // UPDATE STATUS
    public ViolationResponseDTO
    updateViolationStatus(
            UUID id,
            ViolationStatus status) {

        Violation violation =
                violationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Violation not found with id: "
                                                + id));

        violation.setStatus(status);

        if (status == ViolationStatus.RESOLVED) {

            violation.setResolvedAt(
                    LocalDateTime.now());

        } else {

            violation.setResolvedAt(null);
        }

        Violation updatedViolation =
                violationRepo.save(violation);

        return violationMapper
                .toResponseDTO(updatedViolation);
    }


    // DELETE
    public void deleteViolation(UUID id) {

        Violation violation =
                violationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Violation not found with id: "
                                                + id));

        violationRepo.delete(violation);
    }
}