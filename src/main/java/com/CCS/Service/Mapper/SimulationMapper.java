package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.SimulationRequestDTO;
import com.CCS.Service.ResponseDTO.SimulationResponseDTO;
import com.CCS.Service.model.Simulation;

@Component
public class SimulationMapper {

    public Simulation toEntity(
            SimulationRequestDTO dto) {

        Simulation simulation =
                new Simulation();

        simulation.setSimulationName(
                dto.getSimulationName());

        simulation.setDescription(
                dto.getDescription());

        simulation.setScenario(
                dto.getScenario());

        simulation.setStatus("CREATED");

        simulation.setCreatedAt(
                LocalDateTime.now());

        return simulation;
    }


    public SimulationResponseDTO toResponseDTO(
            Simulation simulation) {

        SimulationResponseDTO dto =
                new SimulationResponseDTO();

        dto.setSimulationId(
                simulation.getSimulationId());

        dto.setSimulationName(
                simulation.getSimulationName());

        dto.setDescription(
                simulation.getDescription());

        dto.setScenario(
                simulation.getScenario());

        dto.setStatus(
                simulation.getStatus());

        dto.setCreatedAt(
                simulation.getCreatedAt());

        return dto;
    }
}