package com.CCS.Service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CCS.Service.ApiResponse.ApiResponse;
import com.CCS.Service.Service.AIChatSessionService;
import com.CCS.Service.model.AIChatSession;

@RestController
@RequestMapping("/api/aichatsession")
public class AIChatSessionController {

    @Autowired
    private AIChatSessionService aiChatSessionService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<AIChatSession>>> getAllAIChatSessions() {

        List<AIChatSession> aiChatSessions =
                aiChatSessionService.getAllAIChatSessions();

        return ResponseEntity.ok(
                new ApiResponse<>("AI Chat Sessions fetched successfully",
                        aiChatSessions, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<AIChatSession>>> getAIChatSessionById(
            @PathVariable UUID id) {

        Optional<AIChatSession> aiChatSession =
                aiChatSessionService.getAIChatSession(id);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Chat Session fetched successfully",
                        aiChatSession, true));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AIChatSession>> createAIChatSession(
            @RequestBody AIChatSession aiChatSession) {

        AIChatSession createdAIChatSession =
                aiChatSessionService.newAIChatSession(aiChatSession);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Chat Session created successfully",
                        createdAIChatSession, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AIChatSession>> updateAIChatSession(
            @PathVariable Long id,
            @RequestBody AIChatSession aiChatSession) {

        AIChatSession updatedAIChatSession =
                aiChatSessionService.UpdateAIChatSession(aiChatSession);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Chat Session updated successfully",
                        updatedAIChatSession, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAIChatSession(
            @PathVariable UUID id) {

        aiChatSessionService.deleteAIChatSession(id);

        return ResponseEntity.ok(
                new ApiResponse<>("AI Chat Session deleted successfully",
                        null, true));
    }
}