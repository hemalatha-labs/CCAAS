package model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="RemediationSuggestion")
@Data


public class RemediationSuggestion {

	@Id
	private Long remediationId;
	private String aiExplanation;
	private String fixSteps;
	private Integer estimatedRiskReduction;
}
