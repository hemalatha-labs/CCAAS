package model;
import java.time.LocalDateTime;

import Enumuration.AuditAction;
import Enumuration.ModuleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="AuditLog")
@Data


public class AuditLog {
	@Id
	private Long auditId;
	@Enumerated(EnumType.STRING)
	private AuditAction action;
	private ModuleType module;
	private LocalDateTime Timestamp;
	

}
