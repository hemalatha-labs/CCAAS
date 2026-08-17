package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.SimulationMapper;
import com.CCS.Service.Repo.SimulationRepo;
import com.CCS.Service.RequestDTO.SimulationRequestDTO;
import com.CCS.Service.ResponseDTO.SimulationResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.Simulation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimulationService {

    @Autowired
    private SimulationRepo simulationRepo;

    @Autowired
    private SimulationMapper simulationMapper;


    public List<SimulationResponseDTO>
    getAllSimulations() {

        return simulationRepo.findAll()
                .stream()
                .map(simulationMapper::toResponseDTO)
                .toList();
    }


    public SimulationResponseDTO
    getSimulation(UUID id) {

        Simulation simulation =
                simulationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Simulation not found with id: "
                                                + id));

        return simulationMapper.toResponseDTO(
                simulation);
    }


    public SimulationResponseDTO
    newSimulation(
            SimulationRequestDTO dto) {

        Simulation simulation =
                simulationMapper.toEntity(dto);

        return simulationMapper.toResponseDTO(
                simulationRepo.save(simulation));
    }


    public SimulationResponseDTO
    updateSimulation(
            UUID id,
            SimulationRequestDTO dto) {

        Simulation existing =
                simulationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Simulation not found with id: "
                                                + id));

        if (dto.getSimulationName() != null) {
            existing.setSimulationName(
                    dto.getSimulationName());
        }

        if (dto.getDescription() != null) {
            existing.setDescription(
                    dto.getDescription());
        }

        if (dto.getScenario() != null) {
            existing.setScenario(
                    dto.getScenario());
        }

        return simulationMapper.toResponseDTO(
                simulationRepo.save(existing));
    }


    public void deleteSimulation(UUID id) {

        Simulation simulation =
                simulationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Simulation not found with id: "
                                                + id));

        simulationRepo.delete(simulation);
    }
}