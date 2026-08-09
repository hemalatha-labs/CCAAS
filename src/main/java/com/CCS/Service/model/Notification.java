package com.CCS.Service.model;


import com.CCS.Service.Enumuration.NotificationPriority;
import com.CCS.Service.Enumuration.NotificationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Notification")
@Data



public class Notification {
	@Id
	private long notificationId;
	private String message;
	@Enumerated(EnumType.STRING)
	private NotificationPriority priority;
	@Enumerated(EnumType.STRING)
	private NotificationStatus status;
	
	
	
	

}
