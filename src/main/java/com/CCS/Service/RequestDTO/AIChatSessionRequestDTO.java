package com.CCS.Service.RequestDTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AIChatSessionRequestDTO {

    @NotBlank(message = "Session name is required")
    private String sessionName;

    @NotBlank(message = "User message is required")
    private String userMessage;

    private String aiResponse;

    private Boolean active;
}