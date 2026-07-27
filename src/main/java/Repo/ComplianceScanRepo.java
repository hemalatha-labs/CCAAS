package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ComplianceScan;
@Repository

public interface ComplianceScanRepo extends JpaRepository<ComplianceScan,Long> {

}
