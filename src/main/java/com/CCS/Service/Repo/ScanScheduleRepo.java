package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.ScanSchedule;

public interface ScanScheduleRepo
        extends JpaRepository<ScanSchedule, UUID> {

    List<ScanSchedule> findByCloudAccountCloudAccountId(
            UUID cloudAccountId);
}