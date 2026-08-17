package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AIChatSessionResponseDTO {

    private UUID sessionId;

    private String sessionName;

    private String userMessage;

    private String aiResponse;

    private LocalDateTime createdAt;

    private Boolean active;
}