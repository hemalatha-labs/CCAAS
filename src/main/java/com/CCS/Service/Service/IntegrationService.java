package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.IntegrationMapper;
import com.CCS.Service.Repo.IntegrationRepo;
import com.CCS.Service.RequestDTO.IntegrationRequestDTO;
import com.CCS.Service.ResponseDTO.IntegrationResponseDTO;
import com.CCS.Service.Validation.IntegrationValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.Integration;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IntegrationService {

    @Autowired
    private IntegrationRepo integrationRepo;

    @Autowired
    private IntegrationMapper integrationMapper;

    @Autowired
    private IntegrationValidator integrationValidator;


    // GET ALL
    public List<IntegrationResponseDTO> getAllIntegrations() {

        return integrationRepo.findAll()
                .stream()
                .map(integrationMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public IntegrationResponseDTO getIntegration(UUID id) {

        Integration integration =
                integrationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Integration not found with id: "
                                                + id));

        return integrationMapper.toResponseDTO(
                integration);
    }


    // CREATE
    public IntegrationResponseDTO newIntegration(
            IntegrationRequestDTO dto) {

        integrationValidator.validate(dto);

        Integration integration =
                integrationMapper.toEntity(dto);

        Integration savedIntegration =
                integrationRepo.save(integration);

        return integrationMapper.toResponseDTO(
                savedIntegration);
    }


    // UPDATE
    public IntegrationResponseDTO updateIntegration(
            UUID id,
            IntegrationRequestDTO dto) {

        integrationValidator.validate(dto);

        Integration existingIntegration =
                integrationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Integration not found with id: "
                                                + id));

        existingIntegration.setIntegrationName(
                dto.getIntegrationName());

        existingIntegration.setIntegrationType(
                dto.getIntegrationType());

        existingIntegration.setCredentials(
                dto.getCredentials());

        Integration updatedIntegration =
                integrationRepo.save(
                        existingIntegration);

        return integrationMapper.toResponseDTO(
                updatedIntegration);
    }


    // DELETE
    public void deleteIntegration(UUID id) {

        Integration integration =
                integrationRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Integration not found with id: "
                                                + id));

        integrationRepo.delete(integration);
    }
}