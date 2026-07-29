package com.CCS.Service.model;

import java.time.LocalDateTime;

import com.CCS.Service.Enumuration.ScanFrequency;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ScanSchedule")
@Data

public class ScanSchedule {
	
	@Id
	private Long scheduleId;
	@Enumerated(EnumType.STRING)
	private ScanFrequency frequency;
	private LocalDateTime nextRun;
	private Boolean enabled;
	

}
