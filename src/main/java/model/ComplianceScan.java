package model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ComplianceScan")
@Data

public class ComplianceScan {
	
	@Id
	private Long scanId;
	private LocalDateTime scanDate;
	private Integer complianceScore;
	private Integer totalViolations;
	

}
