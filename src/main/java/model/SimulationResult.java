package model;

import Enumuration.ComplianceStatus;
import Enumuration.RiskLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SimulationResult")
@Data

public class SimulationResult {

	@Id
	private Long resultId;
	
	@Enumerated(EnumType.STRING)
	private ComplianceStatus complianceStatus;
	private int predictedViolations;
	private RiskLevel riskLevel;
	
	
	
}
