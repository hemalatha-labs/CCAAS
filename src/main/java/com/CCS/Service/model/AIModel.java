package com.CCS.Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="AIModel")
@Data

public class AIModel {
	@Id
	private Long modelId;
	private String modelName;
	private String algorithm;
	private String version;
	private Double accuracy;
	
	
	

}
