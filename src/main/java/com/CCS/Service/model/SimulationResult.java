package com.CCS.Service.model;

import java.util.UUID;

import com.CCS.Service.Enumuration.ComplianceStatus;
import com.CCS.Service.Enumuration.RiskLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SimulationResult")
@Data

public class SimulationResult {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID resultId;
	
	@Enumerated(EnumType.STRING)
	private ComplianceStatus complianceStatus;
	private int predictedViolations;
	@Enumerated(EnumType.STRING)
	private RiskLevel riskLevel;
	
	
	
}
