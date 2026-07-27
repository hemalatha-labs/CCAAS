package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ScanReport;
@Repository
public interface ScanReportRepo extends JpaRepository<ScanReport,Long> {

}