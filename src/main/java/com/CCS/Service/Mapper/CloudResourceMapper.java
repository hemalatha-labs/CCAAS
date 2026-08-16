package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.CloudResourceStatus;
import com.CCS.Service.RequestDTO.CloudResourceRequestDTO;
import com.CCS.Service.ResponseDTO.CloudResourceResponseDTO;
import com.CCS.Service.model.CloudResource;

@Component
public class CloudResourceMapper {

    public CloudResource toEntity(
            CloudResourceRequestDTO dto) {

        CloudResource resource =
                new CloudResource();

        resource.setResourceName(
                dto.getResourceName());

        resource.setResourceIdentifier(
                dto.getResourceIdentifier());

        resource.setResourceType(
                dto.getResourceType());

        resource.setRegion(
                dto.getRegion());

        resource.setStatus(
                CloudResourceStatus.ACTIVE);

        resource.setCreatedAt(
                LocalDateTime.now());

        return resource;
    }


    public CloudResourceResponseDTO toResponseDTO(
            CloudResource resource) {

        CloudResourceResponseDTO dto =
                new CloudResourceResponseDTO();

        dto.setCloudResourceId(
                resource.getCloudResourceId());

        dto.setResourceName(
                resource.getResourceName());

        dto.setResourceIdentifier(
                resource.getResourceIdentifier());

        dto.setResourceType(
                resource.getResourceType());

        dto.setRegion(
                resource.getRegion());

        dto.setStatus(
                resource.getStatus());

        dto.setCreatedAt(
                resource.getCreatedAt());

        if (resource.getCloudAccount() != null) {

            dto.setCloudAccountId(
                    resource.getCloudAccount()
                            .getCloudAccountId());
        }

        return dto;
    }
}