package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.CompliancePolicy;
@Repository

public interface CompliancePolicyRepo extends JpaRepository<CompliancePolicy,Long> {

}
