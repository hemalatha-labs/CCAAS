package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.AIModelMapper;
import com.CCS.Service.Repo.AIModelRepo;
import com.CCS.Service.RequestDTO.AIModelRequestDTO;
import com.CCS.Service.ResponseDTO.AIModelResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.AIModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIModelService {

    @Autowired
    private AIModelRepo aiModelRepo;

    @Autowired
    private AIModelMapper aiModelMapper;


    // GET ALL
    public List<AIModelResponseDTO> getAllModels() {

        return aiModelRepo.findAll()
                .stream()
                .map(aiModelMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public AIModelResponseDTO getModel(UUID id) {

        AIModel model =
                aiModelRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI model not found with id: " + id));

        return aiModelMapper.toResponseDTO(model);
    }


    // CREATE
    public AIModelResponseDTO newModel(
            AIModelRequestDTO dto) {

        AIModel model =
                aiModelMapper.toEntity(dto);

        AIModel saved =
                aiModelRepo.save(model);

        return aiModelMapper.toResponseDTO(saved);
    }


    // UPDATE
    public AIModelResponseDTO updateModel(
            UUID id,
            AIModelRequestDTO dto) {

        AIModel existingModel =
                aiModelRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI model not found with id: " + id));

        if (dto.getModelName() != null) {
            existingModel.setModelName(dto.getModelName());
        }

        if (dto.getVersion() != null) {
            existingModel.setVersion(dto.getVersion());
        }

        if (dto.getModelType() != null) {
            existingModel.setModelType(dto.getModelType());
        }

        if (dto.getProvider() != null) {
            existingModel.setProvider(dto.getProvider());
        }

        if (dto.getActive() != null) {
            existingModel.setActive(dto.getActive());
        }

        AIModel updated =
                aiModelRepo.save(existingModel);

        return aiModelMapper.toResponseDTO(updated);
    }


    // DELETE
    public void deleteModel(UUID id) {

        AIModel model =
                aiModelRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI model not found with id: " + id));

        aiModelRepo.delete(model);
    }
}