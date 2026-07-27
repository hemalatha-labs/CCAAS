package model;

import java.time.LocalDateTime;

import Enumuration.CloudProvider;
import Enumuration.ConnectionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Integration")
@Data
public class Integration {
	@Id
	private Long integrationId;
	
	@Enumerated(EnumType.STRING)
	
	private CloudProvider provider;
	private ConnectionStatus connectionStatus;
	private LocalDateTime lastSync;
	
	

}
