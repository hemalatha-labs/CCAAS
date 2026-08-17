package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.RemediationSuggestionMapper;
import com.CCS.Service.Repo.RemediationSuggestionRepo;
import com.CCS.Service.Repo.ViolationRepo;
import com.CCS.Service.RequestDTO.RemediationSuggestionRequestDTO;
import com.CCS.Service.ResponseDTO.RemediationSuggestionResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.RemediationSuggestion;
import com.CCS.Service.model.Violation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemediationSuggestionService {

    @Autowired
    private RemediationSuggestionRepo
            remediationSuggestionRepo;

    @Autowired
    private ViolationRepo violationRepo;

    @Autowired
    private RemediationSuggestionMapper
            remediationSuggestionMapper;


    // GET ALL
    public List<RemediationSuggestionResponseDTO>
    getAllSuggestions() {

        return remediationSuggestionRepo.findAll()
                .stream()
                .map(remediationSuggestionMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public RemediationSuggestionResponseDTO
    getSuggestion(UUID id) {

        RemediationSuggestion suggestion =
                remediationSuggestionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Remediation suggestion not found with id: "
                                                + id));

        return remediationSuggestionMapper
                .toResponseDTO(suggestion);
    }


    // CREATE
    public RemediationSuggestionResponseDTO
    newSuggestion(
            RemediationSuggestionRequestDTO dto) {

        Violation violation =
                violationRepo.findById(
                        dto.getViolationId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Violation not found with id: "
                                                + dto.getViolationId()));

        RemediationSuggestion suggestion =
                remediationSuggestionMapper
                        .toEntity(dto);

        suggestion.setViolation(violation);

        RemediationSuggestion saved =
                remediationSuggestionRepo
                        .save(suggestion);

        return remediationSuggestionMapper
                .toResponseDTO(saved);
    }


    // DELETE
    public void deleteSuggestion(UUID id) {

        RemediationSuggestion suggestion =
                remediationSuggestionRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Remediation suggestion not found with id: "
                                                + id));

        remediationSuggestionRepo.delete(suggestion);
    }
}