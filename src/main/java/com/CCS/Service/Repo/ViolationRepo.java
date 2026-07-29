package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.Violation;
@Repository

public interface ViolationRepo extends JpaRepository<Violation,Long>{

}
