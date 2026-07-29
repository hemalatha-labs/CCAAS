package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.CompliancePolicy;
@Repository

public interface CompliancePolicyRepo extends JpaRepository<CompliancePolicy,Long> {

}
