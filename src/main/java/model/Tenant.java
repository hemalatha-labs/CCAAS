package model;

import java.time.LocalDateTime;

import Enumuration.IndustryType;
import Enumuration.SubscriptionPlan;
import Enumuration.TenantStatus;
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
	private SubscriptionPlan subscriptionPlan;
	private TenantStatus status;
	private LocalDateTime createdAT;
	
	
	

}
