package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.ComplianceScan;
@Repository

public interface ComplianceScanRepo extends JpaRepository<ComplianceScan,UUID> {

}
