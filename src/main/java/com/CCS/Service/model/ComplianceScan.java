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
@Table(name="ComplianceScan")
@Data

public class ComplianceScan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID scanId;
	private LocalDateTime scanDate;
	private Integer complianceScore;
	private Integer totalViolations;
	

}
