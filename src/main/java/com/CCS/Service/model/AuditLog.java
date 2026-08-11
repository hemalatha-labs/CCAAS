package com.CCS.Service.model;
import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.AuditAction;
import com.CCS.Service.Enumuration.ModuleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="AuditLog")
@Data


public class AuditLog {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID auditId;
	@Enumerated(EnumType.STRING)
	private AuditAction action;
	@Enumerated(EnumType.STRING)
	private ModuleType module;
	private LocalDateTime Timestamp;
	

}
