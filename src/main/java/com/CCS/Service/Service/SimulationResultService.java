package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.SimulationResultMapper;
import com.CCS.Service.Repo.SimulationRepo;
import com.CCS.Service.Repo.SimulationResultRepo;
import com.CCS.Service.RequestDTO.SimulationResultRequestDTO;
import com.CCS.Service.ResponseDTO.SimulationResultResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.Simulation;
import com.CCS.Service.model.SimulationResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimulationResultService {

    @Autowired
    private SimulationResultRepo simulationResultRepo;

    @Autowired
    private SimulationRepo simulationRepo;

    @Autowired
    private SimulationResultMapper simulationResultMapper;


    public List<SimulationResultResponseDTO>
    getAllResults() {

        return simulationResultRepo.findAll()
                .stream()
                .map(simulationResultMapper::toResponseDTO)
                .toList();
    }


    public SimulationResultResponseDTO
    getResult(UUID id) {

        SimulationResult result =
                simulationResultRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Simulation result not found with id: "
                                                + id));

        return simulationResultMapper
                .toResponseDTO(result);
    }


    public SimulationResultResponseDTO
    newResult(
            SimulationResultRequestDTO dto) {

        Simulation simulation =
                simulationRepo.findById(
                        dto.getSimulationId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Simulation not found with id: "
                                                + dto.getSimulationId()));

        SimulationResult result =
                simulationResultMapper.toEntity(dto);

        result.setSimulation(simulation);

        return simulationResultMapper.toResponseDTO(
                simulationResultRepo.save(result));
    }


    public void deleteResult(UUID id) {

        SimulationResult result =
                simulationResultRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Simulation result not found with id: "
                                                + id));

        simulationResultRepo.delete(result);
    }
}