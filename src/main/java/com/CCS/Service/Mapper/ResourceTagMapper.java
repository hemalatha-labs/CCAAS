package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.TagStatus;
import com.CCS.Service.RequestDTO.ResourceTagRequestDTO;
import com.CCS.Service.ResponseDTO.ResourceTagResponseDTO;
import com.CCS.Service.model.ResourceTag;

@Component
public class ResourceTagMapper {

    public ResourceTag toEntity(
            ResourceTagRequestDTO dto) {

        ResourceTag tag = new ResourceTag();

        tag.setTagKey(dto.getTagKey());

        tag.setTagValue(dto.getTagValue());

        tag.setStatus(TagStatus.ACTIVE);

        tag.setCreatedAt(LocalDateTime.now());

        return tag;
    }


    public ResourceTagResponseDTO toResponseDTO(
            ResourceTag tag) {

        ResourceTagResponseDTO dto =
                new ResourceTagResponseDTO();

        dto.setTagId(tag.getTagId());

        dto.setTagKey(tag.getTagKey());

        dto.setTagValue(tag.getTagValue());

        dto.setStatus(tag.getStatus());

        dto.setCreatedAt(tag.getCreatedAt());

        if (tag.getCloudResource() != null) {

            dto.setCloudResourceId(
                    tag.getCloudResource()
                            .getCloudResourceId());
        }

        return dto;
    }
}