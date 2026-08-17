package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.AIModel;

public interface AIModelRepo extends JpaRepository<AIModel, UUID> {

}