package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.RemediationSuggestionRequestDTO;
import com.CCS.Service.ResponseDTO.RemediationSuggestionResponseDTO;
import com.CCS.Service.model.RemediationSuggestion;

@Component
public class RemediationSuggestionMapper {

    public RemediationSuggestion toEntity(
            RemediationSuggestionRequestDTO dto) {

        RemediationSuggestion suggestion =
                new RemediationSuggestion();

        suggestion.setTitle(dto.getTitle());

        suggestion.setDescription(
                dto.getDescription());

        suggestion.setPriority(
                dto.getPriority());

        suggestion.setCreatedAt(
                LocalDateTime.now());

        return suggestion;
    }


    public RemediationSuggestionResponseDTO
    toResponseDTO(
            RemediationSuggestion suggestion) {

        RemediationSuggestionResponseDTO dto =
                new RemediationSuggestionResponseDTO();

        dto.setSuggestionId(
                suggestion.getSuggestionId());

        dto.setTitle(
                suggestion.getTitle());

        dto.setDescription(
                suggestion.getDescription());

        dto.setPriority(
                suggestion.getPriority());

        dto.setCreatedAt(
                suggestion.getCreatedAt());

        if (suggestion.getViolation() != null) {

            dto.setViolationId(
                    suggestion.getViolation()
                            .getViolationId());
        }

        return dto;
    }
}