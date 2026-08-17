package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.ComplianceScan;

public interface ComplianceScanRepo
        extends JpaRepository<ComplianceScan, UUID> {

    List<ComplianceScan> findByScanScheduleScheduleId(
            UUID scheduleId);
}