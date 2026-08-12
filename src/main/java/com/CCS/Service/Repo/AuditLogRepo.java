package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.AuditLog;
@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog,UUID>{

}
