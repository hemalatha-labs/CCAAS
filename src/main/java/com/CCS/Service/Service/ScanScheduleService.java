package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.ScanScheduleMapper;
import com.CCS.Service.Repo.CloudAccountRepo;
import com.CCS.Service.Repo.ScanScheduleRepo;
import com.CCS.Service.RequestDTO.ScanScheduleRequestDTO;
import com.CCS.Service.ResponseDTO.ScanScheduleResponseDTO;
import com.CCS.Service.Validation.ScanScheduleValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.CloudAccount;
import com.CCS.Service.model.ScanSchedule;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScanScheduleService {

    @Autowired
    private ScanScheduleRepo scanScheduleRepo;

    @Autowired
    private CloudAccountRepo cloudAccountRepo;

    @Autowired
    private ScanScheduleMapper scanScheduleMapper;

    @Autowired
    private ScanScheduleValidator scanScheduleValidator;


    // GET ALL
    public List<ScanScheduleResponseDTO>
    getAllScanSchedules() {

        return scanScheduleRepo.findAll()
                .stream()
                .map(scanScheduleMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public ScanScheduleResponseDTO
    getScanSchedule(UUID id) {

        ScanSchedule schedule =
                scanScheduleRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Scan schedule not found with id: "
                                                + id));

        return scanScheduleMapper
                .toResponseDTO(schedule);
    }


    // GET BY CLOUD ACCOUNT
    public List<ScanScheduleResponseDTO>
    getSchedulesByCloudAccount(
            UUID cloudAccountId) {

        cloudAccountRepo.findById(cloudAccountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud account not found with id: "
                                        + cloudAccountId));

        return scanScheduleRepo
                .findByCloudAccountCloudAccountId(
                        cloudAccountId)
                .stream()
                .map(scanScheduleMapper::toResponseDTO)
                .toList();
    }


    // CREATE
    public ScanScheduleResponseDTO
    newScanSchedule(
            ScanScheduleRequestDTO dto) {

        scanScheduleValidator.validate(dto);

        CloudAccount cloudAccount =
                cloudAccountRepo.findById(
                        dto.getCloudAccountId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud account not found with id: "
                                                + dto.getCloudAccountId()));

        ScanSchedule schedule =
                scanScheduleMapper.toEntity(dto);

        schedule.setCloudAccount(
                cloudAccount);

        ScanSchedule savedSchedule =
                scanScheduleRepo.save(schedule);

        return scanScheduleMapper
                .toResponseDTO(savedSchedule);
    }


    // UPDATE
    public ScanScheduleResponseDTO
    updateScanSchedule(
            UUID id,
            ScanScheduleRequestDTO dto) {

        scanScheduleValidator.validate(dto);

        ScanSchedule existingSchedule =
                scanScheduleRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Scan schedule not found with id: "
                                                + id));

        CloudAccount cloudAccount =
                cloudAccountRepo.findById(
                        dto.getCloudAccountId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud account not found with id: "
                                                + dto.getCloudAccountId()));

        existingSchedule.setScheduleName(
                dto.getScheduleName());

        existingSchedule.setFrequency(
                dto.getFrequency());

        if (dto.getEnabled() == null) {

            existingSchedule.setEnabled(true);

        } else {

            existingSchedule.setEnabled(
                    dto.getEnabled());
        }

        existingSchedule.setCloudAccount(
                cloudAccount);

        ScanSchedule updatedSchedule =
                scanScheduleRepo.save(
                        existingSchedule);

        return scanScheduleMapper
                .toResponseDTO(updatedSchedule);
    }


    // DELETE
    public void deleteScanSchedule(UUID id) {

        ScanSchedule schedule =
                scanScheduleRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Scan schedule not found with id: "
                                                + id));

        scanScheduleRepo.delete(schedule);
    }
}