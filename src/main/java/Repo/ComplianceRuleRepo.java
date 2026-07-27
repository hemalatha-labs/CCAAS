package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ComplianceRule;
@Repository
public interface ComplianceRuleRepo extends JpaRepository<ComplianceRule,Long> {

}
