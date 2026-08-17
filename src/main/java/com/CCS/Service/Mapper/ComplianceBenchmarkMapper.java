package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.ComplianceBenchmarkRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceBenchmarkResponseDTO;
import com.CCS.Service.model.ComplianceBenchmark;

@Component
public class ComplianceBenchmarkMapper {

    public ComplianceBenchmark toEntity(
            ComplianceBenchmarkRequestDTO dto) {

        ComplianceBenchmark benchmark =
                new ComplianceBenchmark();

        benchmark.setBenchmarkName(dto.getBenchmarkName());
        benchmark.setBenchmarkVersion(dto.getBenchmarkVersion());
        benchmark.setDescription(dto.getDescription());
        benchmark.setProvider(dto.getProvider());

        if (dto.getActive() != null) {
            benchmark.setActive(dto.getActive());
        } else {
            benchmark.setActive(true);
        }

        benchmark.setCreatedAt(LocalDateTime.now());

        return benchmark;
    }


    public ComplianceBenchmarkResponseDTO
    toResponseDTO(ComplianceBenchmark benchmark) {

        ComplianceBenchmarkResponseDTO dto =
                new ComplianceBenchmarkResponseDTO();

        dto.setBenchmarkId(benchmark.getBenchmarkId());
        dto.setBenchmarkName(benchmark.getBenchmarkName());
        dto.setBenchmarkVersion(benchmark.getBenchmarkVersion());
        dto.setDescription(benchmark.getDescription());
        dto.setProvider(benchmark.getProvider());
        dto.setActive(benchmark.getActive());
        dto.setCreatedAt(benchmark.getCreatedAt());

        return dto;
    }
}