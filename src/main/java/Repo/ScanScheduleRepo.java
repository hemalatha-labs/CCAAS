package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ScanSchedule;
@Repository

public interface ScanScheduleRepo extends JpaRepository<ScanSchedule,Long> {

}
