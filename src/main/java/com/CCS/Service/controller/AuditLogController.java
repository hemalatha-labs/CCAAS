package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.Service.AuditLogService;
import com.CCS.Service.model.AuditLog;

@RestController
@RequestMapping("/api/auditlog")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<AuditLog>>> getAllAuditLogs() {

        List<AuditLog> auditLogs = auditLogService.getAllAuditLogs();

        return ResponseEntity.ok(
                new ApiResponse<>("Audit Logs fetched successfully",
                        auditLogs, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<AuditLog>>> getAuditLogById(
            @PathVariable UUID id) {

        Optional<AuditLog> auditLog = auditLogService.getAuditLog(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Audit Log fetched successfully",
                        auditLog, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AuditLog>> createAuditLog(
            @RequestBody AuditLog auditLog) {

        AuditLog createdAuditLog = auditLogService.newAuditLog(auditLog);

        return ResponseEntity.ok(
                new ApiResponse<>("Audit Log created successfully",
                        createdAuditLog, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AuditLog>> updateAuditLog(
            @PathVariable UUID id,
            @RequestBody AuditLog auditLog) {

        AuditLog updatedAuditLog =
                auditLogService.UpdateAuditLog(auditLog);

        return ResponseEntity.ok(
                new ApiResponse<>("Audit Log updated successfully",
                        updatedAuditLog, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAuditLog(
            @PathVariable UUID id) {

        auditLogService.deleteAuditLog(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Audit Log deleted successfully",
                        null, true));
    }
}