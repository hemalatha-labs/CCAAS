package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ScanReport")
@Data

public class ScanReport {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID reportId;
	private String reprtName;
	private String reportUrl;
	private LocalDateTime Timestamp;
	
	

}
