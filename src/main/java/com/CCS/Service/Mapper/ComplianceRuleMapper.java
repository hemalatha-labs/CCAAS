package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.RuleStatus;
import com.CCS.Service.RequestDTO.ComplianceRuleRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceRuleResponseDTO;
import com.CCS.Service.model.ComplianceRule;

@Component
public class ComplianceRuleMapper {

    public ComplianceRule toEntity(
            ComplianceRuleRequestDTO dto) {

        ComplianceRule rule =
                new ComplianceRule();

        rule.setRuleName(
                dto.getRuleName());

        rule.setDescription(
                dto.getDescription());

        rule.setRuleExpression(
                dto.getRuleExpression());

        rule.setSeverity(
                dto.getSeverity());

        rule.setStatus(
                RuleStatus.ACTIVE);

        rule.setCreatedAt(
                LocalDateTime.now());

        return rule;
    }


    public ComplianceRuleResponseDTO toResponseDTO(
            ComplianceRule rule) {

        ComplianceRuleResponseDTO dto =
                new ComplianceRuleResponseDTO();

        dto.setRuleId(
                rule.getRuleId());

        dto.setRuleName(
                rule.getRuleName());

        dto.setDescription(
                rule.getDescription());

        dto.setRuleExpression(
                rule.getRuleExpression());

        dto.setSeverity(
                rule.getSeverity());

        dto.setStatus(
                rule.getStatus());

        dto.setCreatedAt(
                rule.getCreatedAt());

        if (rule.getCompliancePolicy() != null) {

            dto.setPolicyId(
                    rule.getCompliancePolicy()
                            .getPolicyId());
        }

        return dto;
    }
}