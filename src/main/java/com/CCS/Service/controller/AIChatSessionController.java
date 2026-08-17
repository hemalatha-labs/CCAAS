package com.CCS.Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.RequestDTO.AIChatSessionRequestDTO;
import com.CCS.Service.ResponseDTO.AIChatSessionResponseDTO;
import com.CCS.Service.Service.AIChatSessionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ai-chat-sessions")
@RequiredArgsConstructor
public class AIChatSessionController {

    @Autowired
    private AIChatSessionService aiChatSessionService;


    @GetMapping
    public ResponseEntity<
            ApiResponse<List<AIChatSessionResponseDTO>>>
    getAllSessions() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI chat sessions fetched successfully",
                        aiChatSessionService.getAllSessions(),
                        true));
    }


    @GetMapping("/{id}")
    public ResponseEntity<
            ApiResponse<AIChatSessionResponseDTO>>
    getSession(@PathVariable UUID id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI chat session fetched successfully",
                        aiChatSessionService.getSession(id),
                        true));
    }


    @PostMapping("/new")
    public ResponseEntity<
            ApiResponse<AIChatSessionResponseDTO>>
    newSession(
            @Valid @RequestBody
            AIChatSessionRequestDTO dto) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                        "AI chat session created successfully",
                        aiChatSessionService.newSession(dto),
                        true),
                HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<
            ApiResponse<AIChatSessionResponseDTO>>
    updateSession(
            @PathVariable UUID id,
            @Valid @RequestBody
            AIChatSessionRequestDTO dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI chat session updated successfully",
                        aiChatSessionService
                                .updateSession(id, dto),
                        true));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>>
    deleteSession(@PathVariable UUID id) {

        aiChatSessionService.deleteSession(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "AI chat session deleted successfully",
                        null,
                        true));
    }
}