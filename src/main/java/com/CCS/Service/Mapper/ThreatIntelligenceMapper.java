package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ThreatIntelligenceRequestDTO;
import com.CCS.Service.ResponseDTO.ThreatIntelligenceResponseDTO;
import com.CCS.Service.model.ThreatIntelligence;

@Component
public class ThreatIntelligenceMapper {

    public ThreatIntelligence toEntity(
            ThreatIntelligenceRequestDTO dto) {

        ThreatIntelligence threat =
                new ThreatIntelligence();

        threat.setThreatName(dto.getThreatName());
        threat.setThreatType(dto.getThreatType());
        threat.setDescription(dto.getDescription());
        threat.setSeverity(dto.getSeverity());
        threat.setSource(dto.getSource());

        if (dto.getActive() != null) {
            threat.setActive(dto.getActive());
        } else {
            threat.setActive(true);
        }

        threat.setDetectedAt(LocalDateTime.now());

        return threat;
    }

    public ThreatIntelligenceResponseDTO toResponseDTO(
            ThreatIntelligence threat) {

        ThreatIntelligenceResponseDTO dto =
                new ThreatIntelligenceResponseDTO();

        dto.setThreatId(threat.getThreatId());
        dto.setThreatName(threat.getThreatName());
        dto.setThreatType(threat.getThreatType());
        dto.setDescription(threat.getDescription());
        dto.setSeverity(threat.getSeverity());
        dto.setSource(threat.getSource());
        dto.setActive(threat.getActive());
        dto.setDetectedAt(threat.getDetectedAt());

        return dto;
    }
}