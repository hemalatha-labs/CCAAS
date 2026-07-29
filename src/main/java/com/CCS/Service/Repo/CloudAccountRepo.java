package com.CCS.Service.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.CloudAccount;
@Repository
public interface CloudAccountRepo extends JpaRepository<CloudAccount,Long> {

}
