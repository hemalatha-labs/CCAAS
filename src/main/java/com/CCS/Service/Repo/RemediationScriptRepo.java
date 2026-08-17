package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.RemediationScript;

public interface RemediationScriptRepo
        extends JpaRepository<RemediationScript, UUID> {

}