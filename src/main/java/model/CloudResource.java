package model;

import Enumuration.ResourceStatus;
import Enumuration.ResourceType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CloudResource")
@Data

public class CloudResource {
	
	@Id
	private Long resourceId;
	private String resourceName;
	@Enumerated(EnumType.STRING)
	private ResourceType resourceType;
	private String region;
	private ResourceStatus status;
	
	

}
