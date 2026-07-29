package com.CCS.Service.model;

import com.CCS.Service.Enumuration.PolicyCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CompliancePolicy")
@Data

public class CompliancePolicy {

	@Id
	private Long policyId;
	private String policyName;
	@Enumerated(EnumType.STRING)
	private PolicyCategory category;
	private String version;
	
}
