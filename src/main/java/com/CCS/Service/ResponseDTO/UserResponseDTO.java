package com.CCS.Service.ResponseDTO;

import java.util.UUID;

import lombok.Data;

@Data
public class UserResponseDTO {

    private UUID userId;

    private String name;

    private String email;

    private String role;

    private String status;

    private UUID tenantId;
}