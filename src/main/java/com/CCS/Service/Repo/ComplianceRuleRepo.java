package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.ComplianceRule;

public interface ComplianceRuleRepo
        extends JpaRepository<ComplianceRule, UUID> {

    boolean existsByRuleName(String ruleName);

    List<ComplianceRule> findByCompliancePolicyPolicyId(
            UUID policyId);
}