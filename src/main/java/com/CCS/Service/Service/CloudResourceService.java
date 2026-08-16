package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.CloudResourceMapper;
import com.CCS.Service.Repo.CloudAccountRepo;
import com.CCS.Service.Repo.CloudResourceRepo;
import com.CCS.Service.RequestDTO.CloudResourceRequestDTO;
import com.CCS.Service.ResponseDTO.CloudResourceResponseDTO;
import com.CCS.Service.Validation.CloudResourceValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.CloudAccount;
import com.CCS.Service.model.CloudResource;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudResourceService {

    @Autowired
    private CloudResourceRepo cloudResourceRepo;

    @Autowired
    private CloudAccountRepo cloudAccountRepo;

    @Autowired
    private CloudResourceMapper cloudResourceMapper;

    @Autowired
    private CloudResourceValidator cloudResourceValidator;


    // GET ALL
    public List<CloudResourceResponseDTO>
    getAllCloudResources() {

        return cloudResourceRepo.findAll()
                .stream()
                .map(cloudResourceMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public CloudResourceResponseDTO
    getCloudResource(UUID id) {

        CloudResource resource =
                cloudResourceRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + id));

        return cloudResourceMapper.toResponseDTO(
                resource);
    }


    // GET BY CLOUD ACCOUNT
    public List<CloudResourceResponseDTO>
    getResourcesByCloudAccount(UUID cloudAccountId) {

        // Check cloud account exists
        cloudAccountRepo.findById(cloudAccountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud account not found with id: "
                                        + cloudAccountId));

        return cloudResourceRepo
                .findByCloudAccountCloudAccountId(
                        cloudAccountId)
                .stream()
                .map(cloudResourceMapper::toResponseDTO)
                .toList();
    }


    // CREATE
    public CloudResourceResponseDTO
    newCloudResource(
            CloudResourceRequestDTO dto) {

        cloudResourceValidator.validate(dto);

        CloudAccount cloudAccount =
                cloudAccountRepo.findById(
                        dto.getCloudAccountId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud account not found with id: "
                                                + dto.getCloudAccountId()));

        CloudResource resource =
                cloudResourceMapper.toEntity(dto);

        resource.setCloudAccount(
                cloudAccount);

        CloudResource savedResource =
                cloudResourceRepo.save(resource);

        return cloudResourceMapper.toResponseDTO(
                savedResource);
    }


    // UPDATE
    public CloudResourceResponseDTO
    updateCloudResource(
            UUID id,
            CloudResourceRequestDTO dto) {

        cloudResourceValidator.validate(dto);

        CloudResource existingResource =
                cloudResourceRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + id));

        CloudAccount cloudAccount =
                cloudAccountRepo.findById(
                        dto.getCloudAccountId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud account not found with id: "
                                                + dto.getCloudAccountId()));

        existingResource.setResourceName(
                dto.getResourceName());

        existingResource.setResourceIdentifier(
                dto.getResourceIdentifier());

        existingResource.setResourceType(
                dto.getResourceType());

        existingResource.setRegion(
                dto.getRegion());

        existingResource.setCloudAccount(
                cloudAccount);

        CloudResource updatedResource =
                cloudResourceRepo.save(
                        existingResource);

        return cloudResourceMapper.toResponseDTO(
                updatedResource);
    }


    // DELETE
    public void deleteCloudResource(UUID id) {

        CloudResource resource =
                cloudResourceRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud resource not found with id: "
                                                + id));

        cloudResourceRepo.delete(resource);
    }
}