package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.AuditLogRequestDTO;
import com.CCS.Service.ResponseDTO.AuditLogResponseDTO;
import com.CCS.Service.Service.AuditLogService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<AuditLogResponseDTO>>>
    getAllAuditLogs() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Audit logs fetched successfully",
                        auditLogService
                                .getAllAuditLogs(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<AuditLogResponseDTO>>
    getAuditLog(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Audit log fetched successfully",
                        auditLogService
                                .getAuditLog(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<AuditLogResponseDTO>>
    newAuditLog(
            @Valid @RequestBody
            AuditLogRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "Audit log created successfully",
                        auditLogService
                                .newAuditLog(dto),
                        true),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteAuditLog(
            @PathVariable UUID id) {

        auditLogService.deleteAuditLog(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Audit log deleted successfully",
                        null,
                        true));
    }
}