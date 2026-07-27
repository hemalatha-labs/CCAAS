package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ComplianceBenchmark")
@Data
public class ComplianceBenchmark {

	@Id
	private Long benchmarkId;
	private String industry;
	private Integer averageScore;
	private String bestPractice;
	
}
