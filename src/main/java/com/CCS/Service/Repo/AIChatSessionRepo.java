package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.AIChatSession;

public interface AIChatSessionRepo
        extends JpaRepository<AIChatSession, UUID> {

}