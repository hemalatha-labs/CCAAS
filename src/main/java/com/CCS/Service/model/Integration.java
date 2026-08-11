package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.CloudProvider;
import com.CCS.Service.Enumuration.ConnectionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Integration")
@Data
public class Integration {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID integrationId;
	
	@Enumerated(EnumType.STRING)
	private CloudProvider provider;
	@Enumerated(EnumType.STRING)
	private ConnectionStatus connectionStatus;
	private LocalDateTime lastSync;
	
	

}
