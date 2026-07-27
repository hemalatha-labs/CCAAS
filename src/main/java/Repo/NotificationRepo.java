package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Notification;
@Repository

public interface NotificationRepo extends JpaRepository<Notification,Long> {

}
