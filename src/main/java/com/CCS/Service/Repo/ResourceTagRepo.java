package com.CCS.Service.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CCS.Service.model.ResourceTag;

public interface ResourceTagRepo
        extends JpaRepository<ResourceTag, UUID> {

    List<ResourceTag> findByCloudResourceCloudResourceId(
            UUID cloudResourceId);
}