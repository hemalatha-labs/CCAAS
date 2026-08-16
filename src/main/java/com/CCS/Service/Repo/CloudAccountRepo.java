package com.CCS.Service.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.CloudAccount;

public interface CloudAccountRepo
        extends JpaRepository<CloudAccount, UUID> {

}