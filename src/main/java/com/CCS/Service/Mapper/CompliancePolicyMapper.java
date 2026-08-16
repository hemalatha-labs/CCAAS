package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.PolicyStatus;
import com.CCS.Service.RequestDTO.CompliancePolicyRequestDTO;
import com.CCS.Service.ResponseDTO.CompliancePolicyResponseDTO;
import com.CCS.Service.model.CompliancePolicy;

@Component
public class CompliancePolicyMapper {

    public CompliancePolicy toEntity(
            CompliancePolicyRequestDTO dto) {

        CompliancePolicy policy =
                new CompliancePolicy();

        policy.setPolicyName(
                dto.getPolicyName());

        policy.setDescription(
                dto.getDescription());

        policy.setVersion(
                dto.getVersion());

        policy.setStatus(
                PolicyStatus.ACTIVE);

        policy.setCreatedAt(
                LocalDateTime.now());

        return policy;
    }


    public CompliancePolicyResponseDTO toResponseDTO(
            CompliancePolicy policy) {

        CompliancePolicyResponseDTO dto =
                new CompliancePolicyResponseDTO();

        dto.setPolicyId(
                policy.getPolicyId());

        dto.setPolicyName(
                policy.getPolicyName());

        dto.setDescription(
                policy.getDescription());

        dto.setVersion(
                policy.getVersion());

        dto.setStatus(
                policy.getStatus());

        dto.setCreatedAt(
                policy.getCreatedAt());

        if (policy.getComplianceFramework() != null) {

            dto.setFrameworkId(
                    policy.getComplianceFramework()
                            .getFrameworkId());
        }

        return dto;
    }
}