package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.ScanFrequency;

import lombok.Data;

@Data
public class ScanScheduleResponseDTO {

    private UUID scheduleId;

    private String scheduleName;

    private ScanFrequency frequency;

    private LocalDateTime nextRun;

    private LocalDateTime lastRun;

    private Boolean enabled;

    private LocalDateTime createdAt;

    private UUID cloudAccountId;
}