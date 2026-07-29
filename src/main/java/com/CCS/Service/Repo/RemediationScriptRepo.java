package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.RemediationScript;
@Repository

public interface RemediationScriptRepo extends JpaRepository<RemediationScript,Long> {

}
