package com.CCS.Service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ScanReport")
@Data

public class ScanReport {
	@Id
	private Long reportId;
	private String reprtName;
	private String reportUrl;
	private LocalDateTime Timestamp;
	
	

}
