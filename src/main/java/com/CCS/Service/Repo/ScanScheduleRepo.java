package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.ScanSchedule;
@Repository

public interface ScanScheduleRepo extends JpaRepository<ScanSchedule,Long> {

}
