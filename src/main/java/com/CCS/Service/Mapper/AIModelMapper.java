package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.AIModelRequestDTO;
import com.CCS.Service.ResponseDTO.AIModelResponseDTO;
import com.CCS.Service.model.AIModel;

@Component
public class AIModelMapper {

    public AIModel toEntity(AIModelRequestDTO dto) {

        AIModel model = new AIModel();

        model.setModelName(dto.getModelName());
        model.setVersion(dto.getVersion());
        model.setModelType(dto.getModelType());
        model.setProvider(dto.getProvider());

        if (dto.getActive() != null) {
            model.setActive(dto.getActive());
        } else {
            model.setActive(true);
        }

        model.setCreatedAt(LocalDateTime.now());

        return model;
    }

    public AIModelResponseDTO toResponseDTO(AIModel model) {

        AIModelResponseDTO dto =
                new AIModelResponseDTO();

        dto.setModelId(model.getModelId());
        dto.setModelName(model.getModelName());
        dto.setVersion(model.getVersion());
        dto.setModelType(model.getModelType());
        dto.setProvider(model.getProvider());
        dto.setActive(model.getActive());
        dto.setCreatedAt(model.getCreatedAt());

        return dto;
    }
}