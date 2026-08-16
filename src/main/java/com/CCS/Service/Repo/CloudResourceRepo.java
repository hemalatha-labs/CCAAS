package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.CloudResource;

public interface CloudResourceRepo
        extends JpaRepository<CloudResource, UUID> {

    List<CloudResource> findByCloudAccountCloudAccountId(
            UUID cloudAccountId);
}