package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.AIChatSessionRequestDTO;
import com.CCS.Service.ResponseDTO.AIChatSessionResponseDTO;
import com.CCS.Service.model.AIChatSession;

@Component
public class AIChatSessionMapper {

    public AIChatSession toEntity(
            AIChatSessionRequestDTO dto) {

        AIChatSession session =
                new AIChatSession();

        session.setSessionName(
                dto.getSessionName());

        session.setUserMessage(
                dto.getUserMessage());

        session.setAiResponse(
                dto.getAiResponse());

        if (dto.getActive() != null) {
            session.setActive(dto.getActive());
        } else {
            session.setActive(true);
        }

        session.setCreatedAt(
                LocalDateTime.now());

        return session;
    }


    public AIChatSessionResponseDTO
    toResponseDTO(AIChatSession session) {

        AIChatSessionResponseDTO dto =
                new AIChatSessionResponseDTO();

        dto.setSessionId(
                session.getSessionId());

        dto.setSessionName(
                session.getSessionName());

        dto.setUserMessage(
                session.getUserMessage());

        dto.setAiResponse(
                session.getAiResponse());

        dto.setCreatedAt(
                session.getCreatedAt());

        dto.setActive(
                session.getActive());

        return dto;
    }
}