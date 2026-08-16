package com.CCS.Service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Simulation")
//@Data
public class Simulation {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID simulationId;
	
	
	//@Enumerated
	//private ResourceType resourceType;
	//private ResourceType resourceType;
	
	private String configuration;//JSON if your guide allows it
	private LocalDateTime simulationDate;
	
	
}
