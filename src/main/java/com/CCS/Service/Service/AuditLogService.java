package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.AuditLogMapper;
import com.CCS.Service.Repo.AuditLogRepo;
import com.CCS.Service.RequestDTO.AuditLogRequestDTO;
import com.CCS.Service.ResponseDTO.AuditLogResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.AuditLog;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    @Autowired
    private AuditLogRepo auditLogRepo;

    @Autowired
    private AuditLogMapper auditLogMapper;


    // GET ALL
    public List<AuditLogResponseDTO>
    getAllAuditLogs() {

        return auditLogRepo.findAll()
                .stream()
                .map(auditLogMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public AuditLogResponseDTO
    getAuditLog(UUID id) {

        AuditLog log =
                auditLogRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Audit log not found with id: "
                                                + id));

        return auditLogMapper
                .toResponseDTO(log);
    }


    // CREATE
    public AuditLogResponseDTO
    newAuditLog(
            AuditLogRequestDTO dto) {

        AuditLog log =
                auditLogMapper.toEntity(dto);

        AuditLog saved =
                auditLogRepo.save(log);

        return auditLogMapper
                .toResponseDTO(saved);
    }


    // DELETE
    public void deleteAuditLog(UUID id) {

        AuditLog log =
                auditLogRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Audit log not found with id: "
                                                + id));

        auditLogRepo.delete(log);
    }
}