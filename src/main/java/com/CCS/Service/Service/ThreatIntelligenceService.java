package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ThreatIntelligenceMapper;
import com.CCS.Service.Repo.ThreatIntelligenceRepo;
import com.CCS.Service.RequestDTO.ThreatIntelligenceRequestDTO;
import com.CCS.Service.ResponseDTO.ThreatIntelligenceResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ThreatIntelligence;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThreatIntelligenceService {

    @Autowired
    private ThreatIntelligenceRepo threatIntelligenceRepo;

    @Autowired
    private ThreatIntelligenceMapper threatIntelligenceMapper;


    public List<ThreatIntelligenceResponseDTO>
    getAllThreats() {

        return threatIntelligenceRepo.findAll()
                .stream()
                .map(threatIntelligenceMapper::toResponseDTO)
                .toList();
    }


    public ThreatIntelligenceResponseDTO
    getThreat(UUID id) {

        ThreatIntelligence threat =
                threatIntelligenceRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Threat intelligence not found with id: "
                                                + id));

        return threatIntelligenceMapper
                .toResponseDTO(threat);
    }


    public ThreatIntelligenceResponseDTO
    newThreat(ThreatIntelligenceRequestDTO dto) {

        ThreatIntelligence threat =
                threatIntelligenceMapper.toEntity(dto);

        ThreatIntelligence saved =
                threatIntelligenceRepo.save(threat);

        return threatIntelligenceMapper
                .toResponseDTO(saved);
    }


    public ThreatIntelligenceResponseDTO
    updateThreat(
            UUID id,
            ThreatIntelligenceRequestDTO dto) {

        ThreatIntelligence existing =
                threatIntelligenceRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Threat intelligence not found with id: "
                                                + id));

        if (dto.getThreatName() != null) {
            existing.setThreatName(dto.getThreatName());
        }

        if (dto.getThreatType() != null) {
            existing.setThreatType(dto.getThreatType());
        }

        if (dto.getDescription() != null) {
            existing.setDescription(dto.getDescription());
        }

        if (dto.getSeverity() != null) {
            existing.setSeverity(dto.getSeverity());
        }

        if (dto.getSource() != null) {
            existing.setSource(dto.getSource());
        }

        if (dto.getActive() != null) {
            existing.setActive(dto.getActive());
        }

        return threatIntelligenceMapper.toResponseDTO(
                threatIntelligenceRepo.save(existing));
    }


    public void deleteThreat(UUID id) {

        ThreatIntelligence threat =
                threatIntelligenceRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Threat intelligence not found with id: "
                                                + id));

        threatIntelligenceRepo.delete(threat);
    }
}