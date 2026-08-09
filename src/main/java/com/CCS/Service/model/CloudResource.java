package com.CCS.Service.model;

import com.CCS.Service.Enumuration.ResourceStatus;
import com.CCS.Service.Enumuration.ResourceType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CloudResource")
@Data

public class CloudResource {
	
	@Id
	private Long resourceId;
	private String resourceName;
	@Enumerated(EnumType.STRING)
	private ResourceType resourceType;
	private String region;
	@Enumerated(EnumType.STRING)
	private ResourceStatus status;
	
	

}
