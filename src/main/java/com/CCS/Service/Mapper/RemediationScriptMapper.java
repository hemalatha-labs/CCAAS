package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.RemediationScriptRequestDTO;
import com.CCS.Service.ResponseDTO.RemediationScriptResponseDTO;
import com.CCS.Service.model.RemediationScript;

@Component
public class RemediationScriptMapper {

    public RemediationScript toEntity(
            RemediationScriptRequestDTO dto) {

        RemediationScript script =
                new RemediationScript();

        script.setScriptName(
                dto.getScriptName());

        script.setScriptType(
                dto.getScriptType());

        script.setDescription(
                dto.getDescription());

        script.setScriptContent(
                dto.getScriptContent());

        if (dto.getActive() != null) {
            script.setActive(dto.getActive());
        } else {
            script.setActive(true);
        }

        script.setCreatedAt(
                LocalDateTime.now());

        return script;
    }


    public RemediationScriptResponseDTO
    toResponseDTO(
            RemediationScript script) {

        RemediationScriptResponseDTO dto =
                new RemediationScriptResponseDTO();

        dto.setScriptId(
                script.getScriptId());

        dto.setScriptName(
                script.getScriptName());

        dto.setScriptType(
                script.getScriptType());

        dto.setDescription(
                script.getDescription());

        dto.setScriptContent(
                script.getScriptContent());

        dto.setActive(
                script.getActive());

        dto.setCreatedAt(
                script.getCreatedAt());

        if (script.getSuggestion() != null) {

            dto.setSuggestionId(
                    script.getSuggestion()
                            .getSuggestionId());
        }

        return dto;
    }
}