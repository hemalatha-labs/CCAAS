package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.AuditLog;

public interface AuditLogRepo
        extends JpaRepository<AuditLog, UUID> {
}