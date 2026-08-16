package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ResourceTagMapper;
import com.CCS.Service.Repo.CloudResourceRepo;
import com.CCS.Service.Repo.ResourceTagRepo;
import com.CCS.Service.RequestDTO.ResourceTagRequestDTO;
import com.CCS.Service.ResponseDTO.ResourceTagResponseDTO;
import com.CCS.Service.Validation.ResourceTagValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.CloudResource;
import com.CCS.Service.model.ResourceTag;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResourceTagService {

    @Autowired
    private ResourceTagRepo resourceTagRepo;

    @Autowired
    private CloudResourceRepo cloudResourceRepo;

    @Autowired
    private ResourceTagMapper resourceTagMapper;

    @Autowired
    private ResourceTagValidator resourceTagValidator;


    // GET ALL
    public List<ResourceTagResponseDTO> getAllResourceTags() {

        return resourceTagRepo.findAll()
                .stream()
                .map(resourceTagMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ResourceTagResponseDTO getResourceTag(UUID id) {

        ResourceTag tag =
                resourceTagRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resource tag not found with id: "
                                                + id));

        return resourceTagMapper.toResponseDTO(tag);
    }


    // GET BY CLOUD RESOURCE
    public List<ResourceTagResponseDTO>
    getTagsByCloudResource(UUID cloudResourceId) {

        cloudResourceRepo.findById(cloudResourceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud resource not found with id: "
                                        + cloudResourceId));

        return resourceTagRepo
                .findByCloudResourceCloudResourceId(
                        cloudResourceId)
                .stream()
                .map(resourceTagMapper::toResponseDTO)
                .toList();
    }


    // CREATE
    public ResourceTagResponseDTO newResourceTag(
            ResourceTagRequestDTO dto) {

        resourceTagValidator.validate(dto);

        CloudResource cloudResource =
                cloudResourceRepo.findById(
                        dto.getCloudResourceId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + dto.getCloudResourceId()));

        ResourceTag tag =
                resourceTagMapper.toEntity(dto);

        tag.setCloudResource(cloudResource);

        ResourceTag savedTag =
                resourceTagRepo.save(tag);

        return resourceTagMapper.toResponseDTO(
                savedTag);
    }


    // UPDATE
    public ResourceTagResponseDTO updateResourceTag(
            UUID id,
            ResourceTagRequestDTO dto) {

        resourceTagValidator.validate(dto);

        ResourceTag existingTag =
                resourceTagRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resource tag not found with id: "
                                                + id));

        CloudResource cloudResource =
                cloudResourceRepo.findById(
                        dto.getCloudResourceId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + dto.getCloudResourceId()));

        existingTag.setTagKey(dto.getTagKey());

        existingTag.setTagValue(dto.getTagValue());

        existingTag.setCloudResource(cloudResource);

        ResourceTag updatedTag =
                resourceTagRepo.save(existingTag);

        return resourceTagMapper.toResponseDTO(
                updatedTag);
    }


    // DELETE
    public void deleteResourceTag(UUID id) {

        ResourceTag tag =
                resourceTagRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resource tag not found with id: "
                                                + id));

        resourceTagRepo.delete(tag);
    }
}