package com.CCS.Service.model;

import java.util.UUID;

import com.CCS.Service.Enumuration.CloudProvider;
import com.CCS.Service.Enumuration.ResourceStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CloudAccount")
@Data
public class CloudAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID accountId;
	@Enumerated(EnumType.STRING)
	private CloudProvider provider;
	private String accountName;
	private String accountNumber;
	private String region;
	@Enumerated(EnumType.STRING)
	private ResourceStatus status;
	
}
