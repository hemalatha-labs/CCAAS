package com.CCS.Service.model;


import java.time.LocalDate;

import com.CCS.Service.Enumuration.SubscriptionPlan;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Subscription")
@Data
public class Subscription {
	@Id
	private Long subscriptionId;
	@Enumerated(EnumType.STRING)
	private SubscriptionPlan planName;
	private Double price;
	private Integer maxResources;
	private Integer maxScans;
	private LocalDate expiryDate;
	
	

}
