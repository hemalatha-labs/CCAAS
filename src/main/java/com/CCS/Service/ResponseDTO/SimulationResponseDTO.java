package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class SimulationResponseDTO {

    private UUID simulationId;

    private String simulationName;

    private String description;

    private String scenario;

    private String status;

    private LocalDateTime createdAt;
}