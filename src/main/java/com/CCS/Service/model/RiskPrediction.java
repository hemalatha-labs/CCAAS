package com.CCS.Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="RiskPrediction")
@Data

public class RiskPrediction {
	@Id
	private Long predictionId;
	private Integer currentScore;
	private Integer predictedScore;
	private Double confidence;
	
	
	
	

}
