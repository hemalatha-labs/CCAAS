package com.CCS.Service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ComplianceScoreMapper;
import com.CCS.Service.Repo.ComplianceScoreRepo;
import com.CCS.Service.Repo.ComplianceScanRepo;
import com.CCS.Service.RequestDTO.ComplianceScoreRequestDTO;
import com.CCS.Service.ResponseDTO.ComplianceScoreResponseDTO;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.ComplianceScan;
import com.CCS.Service.model.ComplianceScore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceScoreService {

    @Autowired
    private ComplianceScoreRepo complianceScoreRepo;

    @Autowired
    private ComplianceScanRepo complianceScanRepo;

    @Autowired
    private ComplianceScoreMapper complianceScoreMapper;


    // GET ALL
    public List<ComplianceScoreResponseDTO>
    getAllScores() {

        return complianceScoreRepo.findAll()
                .stream()
                .map(complianceScoreMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ComplianceScoreResponseDTO
    getScore(UUID id) {

        ComplianceScore score =
                complianceScoreRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance score not found with id: "
                                                + id));

        return complianceScoreMapper
                .toResponseDTO(score);
    }


    // CREATE / CALCULATE
    public ComplianceScoreResponseDTO
    calculateScore(
            ComplianceScoreRequestDTO dto) {

        ComplianceScan scan =
                complianceScanRepo.findById(
                        dto.getScanId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance scan not found with id: "
                                                + dto.getScanId()));

        Integer total =
                scan.getTotalResources() == null
                        ? 0
                        : scan.getTotalResources();

        Integer compliant =
                scan.getCompliantResources() == null
                        ? 0
                        : scan.getCompliantResources();

        Integer nonCompliant =
                scan.getNonCompliantResources() == null
                        ? 0
                        : scan.getNonCompliantResources();

        double score = 0.0;

        if (total > 0) {

            score =
                    ((double) compliant / total) * 100;
        }

        ComplianceScore complianceScore =
                new ComplianceScore();

        complianceScore.setScore(score);

        complianceScore.setTotalResources(total);

        complianceScore.setCompliantResources(
                compliant);

        complianceScore.setNonCompliantResources(
                nonCompliant);

        complianceScore.setCalculatedAt(
                LocalDateTime.now());

        complianceScore.setComplianceScan(scan);

        ComplianceScore saved =
                complianceScoreRepo.save(
                        complianceScore);

        return complianceScoreMapper
                .toResponseDTO(saved);
    }


    // DELETE
    public void deleteScore(UUID id) {

        ComplianceScore score =
                complianceScoreRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Compliance score not found with id: "
                                                + id));

        complianceScoreRepo.delete(score);
    }
}