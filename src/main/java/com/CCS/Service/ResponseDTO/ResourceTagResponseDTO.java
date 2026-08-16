package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.TagStatus;

import lombok.Data;

@Data
public class ResourceTagResponseDTO {

    private UUID tagId;

    private String tagKey;

    private String tagValue;

    private TagStatus status;

    private LocalDateTime createdAt;

    private UUID cloudResourceId;
}