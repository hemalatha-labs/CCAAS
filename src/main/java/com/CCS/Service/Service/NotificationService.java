package com.CCS.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.NotificationRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
	
	@Autowired
	private NotificationRepo notificationRepo;
	
	public List<Notification> getAllNotifications(){
		 return notificationRepo.findAll();
	}
	
	public Optional<Notification> getNotification(Long id) {
		return notificationRepo.findById(id);
	}

	public Notification newNotification(Notification notification) {
		return  notificationRepo.save(notification);
	}
	
	public void deleteNotification(Long id) {
		notificationRepo.deleteById(id);
	}
	
	public Notification UpdateNotification(Notification notification) {
		return notificationRepo.save(notification);
	}
}
