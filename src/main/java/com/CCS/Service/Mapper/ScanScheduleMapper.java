package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.ScanFrequency;
import com.CCS.Service.RequestDTO.ScanScheduleRequestDTO;
import com.CCS.Service.ResponseDTO.ScanScheduleResponseDTO;
import com.CCS.Service.model.ScanSchedule;

@Component
public class ScanScheduleMapper {

    public ScanSchedule toEntity(
            ScanScheduleRequestDTO dto) {

        ScanSchedule schedule =
                new ScanSchedule();

        schedule.setScheduleName(
                dto.getScheduleName());

        schedule.setFrequency(
                dto.getFrequency());

        if (dto.getEnabled() == null) {
            schedule.setEnabled(true);
        } else {
            schedule.setEnabled(
                    dto.getEnabled());
        }

        schedule.setCreatedAt(
                LocalDateTime.now());

        schedule.setLastRun(null);

        schedule.setNextRun(
                calculateNextRun(
                        dto.getFrequency()));

        return schedule;
    }


    public ScanScheduleResponseDTO toResponseDTO(
            ScanSchedule schedule) {

        ScanScheduleResponseDTO dto =
                new ScanScheduleResponseDTO();

        dto.setScheduleId(
                schedule.getScheduleId());

        dto.setScheduleName(
                schedule.getScheduleName());

        dto.setFrequency(
                schedule.getFrequency());

        dto.setNextRun(
                schedule.getNextRun());

        dto.setLastRun(
                schedule.getLastRun());

        dto.setEnabled(
                schedule.getEnabled());

        dto.setCreatedAt(
                schedule.getCreatedAt());

        if (schedule.getCloudAccount() != null) {

            dto.setCloudAccountId(
                    schedule.getCloudAccount()
                            .getCloudAccountId());
        }

        return dto;
    }


    private LocalDateTime calculateNextRun(
            ScanFrequency frequency) {

        LocalDateTime now =
                LocalDateTime.now();

        switch (frequency) {

            case DAILY:
                return now.plusDays(1);

            case WEEKLY:
                return now.plusWeeks(1);

            case MONTHLY:
                return now.plusMonths(1);

            default:
                return now.plusDays(1);
        }
    }
}