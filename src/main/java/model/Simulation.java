package model;

import java.time.LocalDateTime;

import Enumuration.ResourceType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Simulation")
@Data
public class Simulation {
	@Id
	private Long simulationId;
	
	
	@Enumerated
	private ResourceType resourceType;
	
	private String configuration;//JSON if your guide allows it
	private LocalDateTime simulationDate;
	
	
}
