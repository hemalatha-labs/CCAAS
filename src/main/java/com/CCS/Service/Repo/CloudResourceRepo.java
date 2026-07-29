package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.CloudResource;
@Repository

public interface CloudResourceRepo extends JpaRepository<CloudResource,Long>{

}
