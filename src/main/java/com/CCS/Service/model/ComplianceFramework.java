package com.CCS.Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ComplianceFramework")
@Data


public class ComplianceFramework {
	
	@Id
	private Long frameworkId;
	private String frameworkName;
	private String version;
	private String description;
	

}
