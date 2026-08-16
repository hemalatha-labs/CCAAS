package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.CloudResourceStatus;
import com.CCS.Service.Enumuration.CloudResourceType;

import lombok.Data;

@Data
public class CloudResourceResponseDTO {

    private UUID cloudResourceId;

    private String resourceName;

    private String resourceIdentifier;

    private CloudResourceType resourceType;

    private String region;

    private CloudResourceStatus status;

    private LocalDateTime createdAt;

    private UUID cloudAccountId;
}