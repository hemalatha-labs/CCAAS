package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ComplianceBenchmark;
@Repository

public interface ComplianceBenchmarkRepo extends JpaRepository<ComplianceBenchmark,Long>{

}
