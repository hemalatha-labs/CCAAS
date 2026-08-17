package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.RemediationScriptMapper;
import com.CCS.Service.Repo.RemediationScriptRepo;
import com.CCS.Service.Repo.RemediationSuggestionRepo;
import com.CCS.Service.RequestDTO.RemediationScriptRequestDTO;
import com.CCS.Service.ResponseDTO.RemediationScriptResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.RemediationScript;
import com.CCS.Service.model.RemediationSuggestion;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemediationScriptService {

    @Autowired
    private RemediationScriptRepo remediationScriptRepo;

    @Autowired
    private RemediationSuggestionRepo
            remediationSuggestionRepo;

    @Autowired
    private RemediationScriptMapper
            remediationScriptMapper;


    // GET ALL
    public List<RemediationScriptResponseDTO>
    getAllScripts() {

        return remediationScriptRepo.findAll()
                .stream()
                .map(remediationScriptMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public RemediationScriptResponseDTO
    getScript(UUID id) {

        RemediationScript script =
                remediationScriptRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Remediation script not found with id: "
                                                + id));

        return remediationScriptMapper
                .toResponseDTO(script);
    }


    // CREATE
    public RemediationScriptResponseDTO
    newScript(
            RemediationScriptRequestDTO dto) {

        RemediationSuggestion suggestion =
                remediationSuggestionRepo.findById(
                        dto.getSuggestionId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Remediation suggestion not found with id: "
                                                + dto.getSuggestionId()));

        RemediationScript script =
                remediationScriptMapper
                        .toEntity(dto);

        script.setSuggestion(suggestion);

        RemediationScript saved =
                remediationScriptRepo.save(script);

        return remediationScriptMapper
                .toResponseDTO(saved);
    }


    // UPDATE
    public RemediationScriptResponseDTO
    updateScript(
            UUID id,
            RemediationScriptRequestDTO dto) {

        RemediationScript existing =
                remediationScriptRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Remediation script not found with id: "
                                                + id));

        if (dto.getScriptName() != null) {
            existing.setScriptName(
                    dto.getScriptName());
        }

        if (dto.getScriptType() != null) {
            existing.setScriptType(
                    dto.getScriptType());
        }

        if (dto.getDescription() != null) {
            existing.setDescription(
                    dto.getDescription());
        }

        if (dto.getScriptContent() != null) {
            existing.setScriptContent(
                    dto.getScriptContent());
        }

        if (dto.getActive() != null) {
            existing.setActive(
                    dto.getActive());
        }

        RemediationScript updated =
                remediationScriptRepo.save(existing);

        return remediationScriptMapper
                .toResponseDTO(updated);
    }


    // DELETE
    public void deleteScript(UUID id) {

        RemediationScript script =
                remediationScriptRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Remediation script not found with id: "
                                                + id));

        remediationScriptRepo.delete(script);
    }
}