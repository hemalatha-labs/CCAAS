package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ComplianceRuleMapper;
import com.CCS.Service.Repo.CompliancePolicyRepo;
import com.CCS.Service.Repo.ComplianceRuleRepo;
import com.CCS.Service.RequestDTO.ComplianceRuleRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceRuleResponseDTO;
import com.CCS.Service.Validation.ComplianceRuleValidator;
import com.CCS.Service.globalException.DuplicateResourceException;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.CompliancePolicy;
import com.CCS.Service.model.ComplianceRule;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceRuleService {

    @Autowired
    private ComplianceRuleRepo complianceRuleRepo;

    @Autowired
    private CompliancePolicyRepo compliancePolicyRepo;

    @Autowired
    private ComplianceRuleMapper complianceRuleMapper;

    @Autowired
    private ComplianceRuleValidator complianceRuleValidator;


    // GET ALL
    public List<ComplianceRuleResponseDTO>
    getAllComplianceRules() {

        return complianceRuleRepo.findAll()
                .stream()
                .map(complianceRuleMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ComplianceRuleResponseDTO
    getComplianceRule(UUID id) {

        ComplianceRule rule =
                complianceRuleRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance rule not found with id: "
                                                + id));

        return complianceRuleMapper
                .toResponseDTO(rule);
    }


    // GET BY POLICY
    public List<ComplianceRuleResponseDTO>
    getRulesByPolicy(UUID policyId) {

        compliancePolicyRepo.findById(policyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Compliance policy not found with id: "
                                        + policyId));

        return complianceRuleRepo
                .findByCompliancePolicyPolicyId(
                        policyId)
                .stream()
                .map(complianceRuleMapper::toResponseDTO)
                .toList();
    }


    // CREATE
    public ComplianceRuleResponseDTO
    newComplianceRule(
            ComplianceRuleRequestDTO dto) {

        complianceRuleValidator.validate(dto);

        if (complianceRuleRepo
                .existsByRuleName(
                        dto.getRuleName())) {

            throw new DuplicateResourceException(
                    "Compliance rule already exists: "
                            + dto.getRuleName());
        }

        CompliancePolicy policy =
                compliancePolicyRepo.findById(
                        dto.getPolicyId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance policy not found with id: "
                                                + dto.getPolicyId()));

        ComplianceRule rule =
                complianceRuleMapper.toEntity(dto);

        rule.setCompliancePolicy(policy);

        ComplianceRule savedRule =
                complianceRuleRepo.save(rule);

        return complianceRuleMapper
                .toResponseDTO(savedRule);
    }


    // UPDATE
    public ComplianceRuleResponseDTO
    updateComplianceRule(
            UUID id,
            ComplianceRuleRequestDTO dto) {

        complianceRuleValidator.validate(dto);

        ComplianceRule existingRule =
                complianceRuleRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance rule not found with id: "
                                                + id));

        if (!existingRule.getRuleName()
                .equals(dto.getRuleName())
                && complianceRuleRepo
                    .existsByRuleName(
                            dto.getRuleName())) {

            throw new DuplicateResourceException(
                    "Compliance rule already exists: "
                            + dto.getRuleName());
        }

        CompliancePolicy policy =
                compliancePolicyRepo.findById(
                        dto.getPolicyId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance policy not found with id: "
                                                + dto.getPolicyId()));

        existingRule.setRuleName(
                dto.getRuleName());

        existingRule.setDescription(
                dto.getDescription());

        existingRule.setRuleExpression(
                dto.getRuleExpression());

        existingRule.setSeverity(
                dto.getSeverity());

        existingRule.setCompliancePolicy(
                policy);

        ComplianceRule updatedRule =
                complianceRuleRepo.save(
                        existingRule);

        return complianceRuleMapper
                .toResponseDTO(updatedRule);
    }


    // DELETE
    public void deleteComplianceRule(UUID id) {

        ComplianceRule rule =
                complianceRuleRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance rule not found with id: "
                                                + id));

        complianceRuleRepo.delete(rule);
    }
}