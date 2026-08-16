package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ComplianceFrameworkMapper;
import com.CCS.Service.Repo.ComplianceFrameworkRepo;
import com.CCS.Service.RequestDTO.ComplianceFrameworkRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceFrameworkResponseDTO;
import com.CCS.Service.Validation.ComplianceFrameworkValidator;
import com.CCS.Service.globalException.DuplicateResourceException;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ComplianceFramework;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceFrameworkService {

    @Autowired
    private ComplianceFrameworkRepo complianceFrameworkRepo;

    @Autowired
    private ComplianceFrameworkMapper complianceFrameworkMapper;

    @Autowired
    private ComplianceFrameworkValidator complianceFrameworkValidator;


    // GET ALL
    public List<ComplianceFrameworkResponseDTO>
    getAllComplianceFrameworks() {

        return complianceFrameworkRepo.findAll()
                .stream()
                .map(complianceFrameworkMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ComplianceFrameworkResponseDTO
    getComplianceFramework(UUID id) {

        ComplianceFramework framework =
                complianceFrameworkRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance framework not found with id: "
                                                + id));

        return complianceFrameworkMapper
                .toResponseDTO(framework);
    }


    // CREATE
    public ComplianceFrameworkResponseDTO
    newComplianceFramework(
            ComplianceFrameworkRequestDTO dto) {

        complianceFrameworkValidator.validate(dto);

        if (complianceFrameworkRepo
                .existsByFrameworkName(
                        dto.getFrameworkName())) {

            throw new DuplicateResourceException(
                    "Compliance framework already exists: "
                            + dto.getFrameworkName());
        }

        ComplianceFramework framework =
                complianceFrameworkMapper.toEntity(dto);

        ComplianceFramework savedFramework =
                complianceFrameworkRepo.save(framework);

        return complianceFrameworkMapper
                .toResponseDTO(savedFramework);
    }


    // UPDATE
    public ComplianceFrameworkResponseDTO
    updateComplianceFramework(
            UUID id,
            ComplianceFrameworkRequestDTO dto) {

        complianceFrameworkValidator.validate(dto);

        ComplianceFramework existingFramework =
                complianceFrameworkRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance framework not found with id: "
                                                + id));

        if (!existingFramework.getFrameworkName()
                .equals(dto.getFrameworkName())
                && complianceFrameworkRepo
                    .existsByFrameworkName(
                            dto.getFrameworkName())) {

            throw new DuplicateResourceException(
                    "Compliance framework already exists: "
                            + dto.getFrameworkName());
        }

        existingFramework.setFrameworkName(
                dto.getFrameworkName());

        existingFramework.setDescription(
                dto.getDescription());

        existingFramework.setVersion(
                dto.getVersion());

        existingFramework.setAuthority(
                dto.getAuthority());

        ComplianceFramework updatedFramework =
                complianceFrameworkRepo.save(
                        existingFramework);

        return complianceFrameworkMapper
                .toResponseDTO(updatedFramework);
    }


    // DELETE
    public void deleteComplianceFramework(UUID id) {

        ComplianceFramework framework =
                complianceFrameworkRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance framework not found with id: "
                                                + id));

        complianceFrameworkRepo.delete(framework);
    }
}