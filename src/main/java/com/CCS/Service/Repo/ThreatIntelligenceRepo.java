package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.ThreatIntelligence;
@Repository

public interface ThreatIntelligenceRepo extends JpaRepository<ThreatIntelligence,Long> {

}
