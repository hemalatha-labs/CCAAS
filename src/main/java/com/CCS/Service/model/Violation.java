package com.CCS.Service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Violation")
@Data

public class Violation {
	@Id
	private Long reportId;
	private String reportName;
	private String reportUrl;
	private LocalDateTime Timestamp;
	
	

}
