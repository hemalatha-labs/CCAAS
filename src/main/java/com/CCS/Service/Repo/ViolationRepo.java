package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.Violation;

public interface ViolationRepo
        extends JpaRepository<Violation, UUID> {

    List<Violation> findByComplianceScanScanId(
            UUID scanId);

    List<Violation> findByStatus(
            com.CCS.Service.Enumuration.ViolationStatus status);
}