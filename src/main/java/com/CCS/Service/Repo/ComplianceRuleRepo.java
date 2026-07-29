package com.CCS.Service.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.ComplianceRule;
@Repository
public interface ComplianceRuleRepo extends JpaRepository<ComplianceRule,Long> {

}
