package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.Integration;
@Repository

public interface IntegrationRepo extends JpaRepository<Integration,Long> {

}
