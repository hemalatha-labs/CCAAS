package com.CCS.Service.model;

import com.CCS.Service.Enumuration.ScriptLanguage;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="RemediationScript")
@Data


public class RemediationScript {

	@Id
	private Long scriptID;
	@Enumerated(EnumType.STRING)
	private ScriptLanguage language;
	private String scriptContent;
	
	
}
