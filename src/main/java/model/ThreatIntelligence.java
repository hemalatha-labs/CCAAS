package model;

import Enumuration.SeverityLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ThreatIntelligence")
@Data

public class ThreatIntelligence {
	
	@Id
	private Long threatId;
	private String source;
	@Enumerated(EnumType.STRING)
	private SeverityLevel severity;
	private String description;
	

}
