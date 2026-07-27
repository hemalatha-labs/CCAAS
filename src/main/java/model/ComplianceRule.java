package model;

import Enumuration.SeverityLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ComplianceRule")
@Data

public class ComplianceRule {
	
	@Id
	private Long ruleId;
	private String ruleName;
	@Enumerated(EnumType.STRING)
	private SeverityLevel severity;
	private String recommendation;
	private Boolean aiGenerated;
	
	
	

}
