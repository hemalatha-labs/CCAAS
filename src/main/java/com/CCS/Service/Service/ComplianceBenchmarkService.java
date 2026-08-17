package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ComplianceBenchmarkMapper;
import com.CCS.Service.Repo.ComplianceBenchmarkRepo;
import com.CCS.Service.RequestDTO.ComplianceBenchmarkRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceBenchmarkResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ComplianceBenchmark;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceBenchmarkService {

    @Autowired
    private ComplianceBenchmarkRepo complianceBenchmarkRepo;

    @Autowired
    private ComplianceBenchmarkMapper complianceBenchmarkMapper;


    public List<ComplianceBenchmarkResponseDTO>
    getAllBenchmarks() {

        return complianceBenchmarkRepo.findAll()
                .stream()
                .map(complianceBenchmarkMapper::toResponseDTO)
                .toList();
    }


    public ComplianceBenchmarkResponseDTO
    getBenchmark(UUID id) {

        ComplianceBenchmark benchmark =
                complianceBenchmarkRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance benchmark not found with id: "
                                                + id));

        return complianceBenchmarkMapper
                .toResponseDTO(benchmark);
    }


    public ComplianceBenchmarkResponseDTO
    newBenchmark(
            ComplianceBenchmarkRequestDTO dto) {

        ComplianceBenchmark benchmark =
                complianceBenchmarkMapper.toEntity(dto);

        return complianceBenchmarkMapper.toResponseDTO(
                complianceBenchmarkRepo.save(benchmark));
    }


    public ComplianceBenchmarkResponseDTO
    updateBenchmark(
            UUID id,
            ComplianceBenchmarkRequestDTO dto) {

        ComplianceBenchmark existing =
                complianceBenchmarkRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance benchmark not found with id: "
                                                + id));

        if (dto.getBenchmarkName() != null) {
            existing.setBenchmarkName(
                    dto.getBenchmarkName());
        }

        if (dto.getBenchmarkVersion() != null) {
            existing.setBenchmarkVersion(
                    dto.getBenchmarkVersion());
        }

        if (dto.getDescription() != null) {
            existing.setDescription(
                    dto.getDescription());
        }

        if (dto.getProvider() != null) {
            existing.setProvider(
                    dto.getProvider());
        }

        if (dto.getActive() != null) {
            existing.setActive(dto.getActive());
        }

        return complianceBenchmarkMapper.toResponseDTO(
                complianceBenchmarkRepo.save(existing));
    }


    public void deleteBenchmark(UUID id) {

        ComplianceBenchmark benchmark =
                complianceBenchmarkRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance benchmark not found with id: "
                                                + id));

        complianceBenchmarkRepo.delete(benchmark);
    }
}