package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ThreatIntelligence;
@Repository

public interface ThreatIntelligenceRepo extends JpaRepository<ThreatIntelligence,Long> {

}
