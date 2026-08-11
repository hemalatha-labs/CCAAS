package com.CCS.Service.model;

import java.util.UUID;

import com.CCS.Service.Enumuration.ResourceStatus;
import com.CCS.Service.Enumuration.ResourceType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CloudResource")
@Data

public class CloudResource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID resourceId;
	private String resourceName;
	@Enumerated(EnumType.STRING)
	private ResourceType resourceType;
	private String region;
	@Enumerated(EnumType.STRING)
	private ResourceStatus status;
	
	

}
