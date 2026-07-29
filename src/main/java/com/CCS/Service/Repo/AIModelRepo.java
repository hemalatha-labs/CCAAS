package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.AIModel;
@Repository

public interface AIModelRepo extends JpaRepository<AIModel,Long> {

}
