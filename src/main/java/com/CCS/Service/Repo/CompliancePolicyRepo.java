package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.CompliancePolicy;

public interface CompliancePolicyRepo
        extends JpaRepository<CompliancePolicy, UUID> {

    boolean existsByPolicyName(String policyName);

    List<CompliancePolicy> findByComplianceFrameworkFrameworkId(
            UUID frameworkId);
}