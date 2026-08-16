package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.CompliancePolicyMapper;
import com.CCS.Service.Repo.ComplianceFrameworkRepo;
import com.CCS.Service.Repo.CompliancePolicyRepo;
import com.CCS.Service.RequestDTO.CompliancePolicyRequestDTO;
import com.CCS.Service.ResponseDTO.CompliancePolicyResponseDTO;
import com.CCS.Service.Validation.CompliancePolicyValidator;
import com.CCS.Service.globalException.DuplicateResourceException;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ComplianceFramework;
import com.CCS.Service.model.CompliancePolicy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompliancePolicyService {

    @Autowired
    private CompliancePolicyRepo compliancePolicyRepo;

    @Autowired
    private ComplianceFrameworkRepo complianceFrameworkRepo;

    @Autowired
    private CompliancePolicyMapper compliancePolicyMapper;

    @Autowired
    private CompliancePolicyValidator compliancePolicyValidator;


    // GET ALL
    public List<CompliancePolicyResponseDTO>
    getAllCompliancePolicies() {

        return compliancePolicyRepo.findAll()
                .stream()
                .map(compliancePolicyMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public CompliancePolicyResponseDTO
    getCompliancePolicy(UUID id) {

        CompliancePolicy policy =
                compliancePolicyRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance policy not found with id: "
                                                + id));

        return compliancePolicyMapper
                .toResponseDTO(policy);
    }


    // GET BY FRAMEWORK
    public List<CompliancePolicyResponseDTO>
    getPoliciesByFramework(UUID frameworkId) {

        complianceFrameworkRepo.findById(frameworkId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Compliance framework not found with id: "
                                        + frameworkId));

        return compliancePolicyRepo
                .findByComplianceFrameworkFrameworkId(
                        frameworkId)
                .stream()
                .map(compliancePolicyMapper::toResponseDTO)
                .toList();
    }


    // CREATE
    public CompliancePolicyResponseDTO
    newCompliancePolicy(
            CompliancePolicyRequestDTO dto) {

        compliancePolicyValidator.validate(dto);

        if (compliancePolicyRepo
                .existsByPolicyName(
                        dto.getPolicyName())) {

            throw new DuplicateResourceException(
                    "Compliance policy already exists: "
                            + dto.getPolicyName());
        }

        ComplianceFramework framework =
                complianceFrameworkRepo.findById(
                        dto.getFrameworkId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance framework not found with id: "
                                                + dto.getFrameworkId()));

        CompliancePolicy policy =
                compliancePolicyMapper.toEntity(dto);

        policy.setComplianceFramework(framework);

        CompliancePolicy savedPolicy =
                compliancePolicyRepo.save(policy);

        return compliancePolicyMapper
                .toResponseDTO(savedPolicy);
    }


    // UPDATE
    public CompliancePolicyResponseDTO
    updateCompliancePolicy(
            UUID id,
            CompliancePolicyRequestDTO dto) {

        compliancePolicyValidator.validate(dto);

        CompliancePolicy existingPolicy =
                compliancePolicyRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance policy not found with id: "
                                                + id));

        if (!existingPolicy.getPolicyName()
                .equals(dto.getPolicyName())
                && compliancePolicyRepo
                    .existsByPolicyName(
                            dto.getPolicyName())) {

            throw new DuplicateResourceException(
                    "Compliance policy already exists: "
                            + dto.getPolicyName());
        }

        ComplianceFramework framework =
                complianceFrameworkRepo.findById(
                        dto.getFrameworkId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance framework not found with id: "
                                                + dto.getFrameworkId()));

        existingPolicy.setPolicyName(
                dto.getPolicyName());

        existingPolicy.setDescription(
                dto.getDescription());

        existingPolicy.setVersion(
                dto.getVersion());

        existingPolicy.setComplianceFramework(
                framework);

        CompliancePolicy updatedPolicy =
                compliancePolicyRepo.save(
                        existingPolicy);

        return compliancePolicyMapper
                .toResponseDTO(updatedPolicy);
    }


    // DELETE
    public void deleteCompliancePolicy(UUID id) {

        CompliancePolicy policy =
                compliancePolicyRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance policy not found with id: "
                                                + id));

        compliancePolicyRepo.delete(policy);
    }
}
