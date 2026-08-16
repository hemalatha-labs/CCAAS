package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.ComplianceFramework;

public interface ComplianceFrameworkRepo
        extends JpaRepository<ComplianceFramework, UUID> {

    boolean existsByFrameworkName(String frameworkName);
}