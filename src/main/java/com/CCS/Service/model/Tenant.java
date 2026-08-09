package com.CCS.Service.model;

import java.time.LocalDateTime;

import com.CCS.Service.Enumuration.IndustryType;
import com.CCS.Service.Enumuration.SubscriptionPlan;
import com.CCS.Service.Enumuration.TenantStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Tenant")
@Data
public class Tenant {
	@Id
	private Long tenantId;
	
	private String tenantName;
	
	
	@Enumerated(EnumType.STRING)
	private IndustryType industry;
	@Enumerated(EnumType.STRING)
	private SubscriptionPlan subscriptionPlan;
	@Enumerated(EnumType.STRING)
	private TenantStatus status;
	private LocalDateTime createdAT;
	
	
	

}
