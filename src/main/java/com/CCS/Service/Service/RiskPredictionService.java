package com.CCS.Service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Enumuration.RiskLevel;
import com.CCS.Service.Mapper.RiskPredictionMapper;
import com.CCS.Service.Repo.AIModelRepo;
import com.CCS.Service.Repo.CloudResourceRepo;
import com.CCS.Service.Repo.RiskPredictionRepo;
import com.CCS.Service.RequestDTO.RiskPredictionRequestDTO;
import com.CCS.Service.ResponseDTO.RiskPredictionResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.AIModel;
import com.CCS.Service.model.CloudResource;
import com.CCS.Service.model.RiskPrediction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiskPredictionService {

    @Autowired
    private RiskPredictionRepo riskPredictionRepo;

    @Autowired
    private AIModelRepo aiModelRepo;

    @Autowired
    private CloudResourceRepo cloudResourceRepo;

    @Autowired
    private RiskPredictionMapper riskPredictionMapper;


    // GET ALL
    public List<RiskPredictionResponseDTO>
    getAllPredictions() {

        return riskPredictionRepo.findAll()
                .stream()
                .map(riskPredictionMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public RiskPredictionResponseDTO
    getPrediction(UUID id) {

        RiskPrediction prediction =
                riskPredictionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Risk prediction not found with id: "
                                                + id));

        return riskPredictionMapper
                .toResponseDTO(prediction);
    }


    // CREATE
    public RiskPredictionResponseDTO
    newPrediction(
            RiskPredictionRequestDTO dto) {

        AIModel model =
                aiModelRepo.findById(dto.getModelId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI model not found with id: "
                                                + dto.getModelId()));

        CloudResource resource =
                cloudResourceRepo.findById(
                        dto.getResourceId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + dto.getResourceId()));

        RiskPrediction prediction =
                new RiskPrediction();

        prediction.setRiskScore(
                dto.getRiskScore());

        prediction.setReason(
                dto.getReason());

        prediction.setRiskLevel(
                calculateRiskLevel(
                        dto.getRiskScore()));

        prediction.setPredictedAt(
                LocalDateTime.now());

        prediction.setAiModel(model);

        prediction.setCloudResource(resource);

        RiskPrediction saved =
                riskPredictionRepo.save(prediction);

        return riskPredictionMapper
                .toResponseDTO(saved);
    }


    private RiskLevel calculateRiskLevel(
            Double score) {

        if (score == null) {
            return RiskLevel.LOW;
        }

        if (score >= 80) {
            return RiskLevel.CRITICAL;
        }

        if (score >= 60) {
            return RiskLevel.HIGH;
        }

        if (score >= 30) {
            return RiskLevel.MEDIUM;
        }

        return RiskLevel.LOW;
    }


    // DELETE
    public void deletePrediction(UUID id) {

        RiskPrediction prediction =
                riskPredictionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Risk prediction not found with id: "
                                                + id));

        riskPredictionRepo.delete(prediction);
    }
}