package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.Notification;
@Repository

public interface NotificationRepo extends JpaRepository<Notification,Long> {

}
