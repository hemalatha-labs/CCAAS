package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ComplianceFrameworkRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceFrameworkResponseDTO;
import com.CCS.Service.model.ComplianceFramework;

@Component
public class ComplianceFrameworkMapper {

    public ComplianceFramework toEntity(
            ComplianceFrameworkRequestDTO dto) {

        ComplianceFramework framework =
                new ComplianceFramework();

        framework.setFrameworkName(
                dto.getFrameworkName());

        framework.setDescription(
                dto.getDescription());

        framework.setVersion(
                dto.getVersion());

        framework.setAuthority(
                dto.getAuthority());

        framework.setCreatedAt(
                LocalDateTime.now());

        return framework;
    }


    public ComplianceFrameworkResponseDTO toResponseDTO(
            ComplianceFramework framework) {

        ComplianceFrameworkResponseDTO dto =
                new ComplianceFrameworkResponseDTO();

        dto.setFrameworkId(
                framework.getFrameworkId());

        dto.setFrameworkName(
                framework.getFrameworkName());

        dto.setDescription(
                framework.getDescription());

        dto.setVersion(
                framework.getVersion());

        dto.setAuthority(
                framework.getAuthority());

        dto.setCreatedAt(
                framework.getCreatedAt());

        return dto;
    }
}