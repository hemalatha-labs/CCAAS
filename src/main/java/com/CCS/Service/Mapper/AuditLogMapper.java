package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.AuditLogRequestDTO;
import com.CCS.Service.ResponseDTO.AuditLogResponseDTO;
import com.CCS.Service.model.AuditLog;

@Component
public class AuditLogMapper {

    public AuditLog toEntity(
            AuditLogRequestDTO dto) {

        AuditLog log =
                new AuditLog();

        log.setUserId(
                dto.getUserId());

        log.setAction(
                dto.getAction());

        log.setEntityName(
                dto.getEntityName());

        log.setEntityId(
                dto.getEntityId());

        log.setDescription(
                dto.getDescription());

        log.setCreatedAt(
                LocalDateTime.now());

        return log;
    }


    public AuditLogResponseDTO toResponseDTO(
            AuditLog log) {

        AuditLogResponseDTO dto =
                new AuditLogResponseDTO();

        dto.setAuditLogId(
                log.getAuditLogId());

        dto.setUserId(
                log.getUserId());

        dto.setAction(
                log.getAction());

        dto.setEntityName(
                log.getEntityName());

        dto.setEntityId(
                log.getEntityId());

        dto.setDescription(
                log.getDescription());

        dto.setCreatedAt(
                log.getCreatedAt());

        return dto;
    }
}