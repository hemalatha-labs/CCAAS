package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.AIChatSessionMapper;
import com.CCS.Service.Repo.AIChatSessionRepo;
import com.CCS.Service.RequestDTO.AIChatSessionRequestDTO;
import com.CCS.Service.ResponseDTO.AIChatSessionResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.AIChatSession;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIChatSessionService {

    @Autowired
    private AIChatSessionRepo aiChatSessionRepo;

    @Autowired
    private AIChatSessionMapper aiChatSessionMapper;


    public List<AIChatSessionResponseDTO>
    getAllSessions() {

        return aiChatSessionRepo.findAll()
                .stream()
                .map(aiChatSessionMapper::toResponseDTO)
                .toList();
    }


    public AIChatSessionResponseDTO
    getSession(UUID id) {

        AIChatSession session =
                aiChatSessionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI chat session not found with id: "
                                                + id));

        return aiChatSessionMapper
                .toResponseDTO(session);
    }


    public AIChatSessionResponseDTO
    newSession(
            AIChatSessionRequestDTO dto) {

        AIChatSession session =
                aiChatSessionMapper.toEntity(dto);

        return aiChatSessionMapper.toResponseDTO(
                aiChatSessionRepo.save(session));
    }


    public AIChatSessionResponseDTO
    updateSession(
            UUID id,
            AIChatSessionRequestDTO dto) {

        AIChatSession existing =
                aiChatSessionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI chat session not found with id: "
                                                + id));

        if (dto.getSessionName() != null) {
            existing.setSessionName(
                    dto.getSessionName());
        }

        if (dto.getUserMessage() != null) {
            existing.setUserMessage(
                    dto.getUserMessage());
        }

        if (dto.getAiResponse() != null) {
            existing.setAiResponse(
                    dto.getAiResponse());
        }

        if (dto.getActive() != null) {
            existing.setActive(
                    dto.getActive());
        }

        return aiChatSessionMapper.toResponseDTO(
                aiChatSessionRepo.save(existing));
    }


    public void deleteSession(UUID id) {

        AIChatSession session =
                aiChatSessionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "AI chat session not found with id: "
                                                + id));

        aiChatSessionRepo.delete(session);
    }
}