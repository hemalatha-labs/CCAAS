package com.CCS.Service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.CCS.Service.Enumuration.CloudAccountStatus;
import com.CCS.Service.RequestDTO.CloudAccountRequestDTO;
import com.CCS.Service.ResponseDTO.CloudAccountResponseDTO;
import com.CCS.Service.model.CloudAccount;

@Component
public class CloudAccountMapper {

    public CloudAccount toEntity(
            CloudAccountRequestDTO dto) {

        CloudAccount cloudAccount = new CloudAccount();

        cloudAccount.setAccountName(
                dto.getAccountName());

        cloudAccount.setAccountIdentifier(
                dto.getAccountIdentifier());

        cloudAccount.setProvider(
                dto.getProvider());

        cloudAccount.setRegion(
                dto.getRegion());

        cloudAccount.setStatus(
                CloudAccountStatus.ACTIVE);

        cloudAccount.setCreatedAt(
                LocalDateTime.now());

        return cloudAccount;
    }


    public CloudAccountResponseDTO toResponseDTO(
            CloudAccount cloudAccount) {

        CloudAccountResponseDTO dto =
                new CloudAccountResponseDTO();

        dto.setCloudAccountId(
                cloudAccount.getCloudAccountId());

        dto.setAccountName(
                cloudAccount.getAccountName());

        dto.setAccountIdentifier(
                cloudAccount.getAccountIdentifier());

        dto.setProvider(
                cloudAccount.getProvider());

        dto.setRegion(
                cloudAccount.getRegion());

        dto.setStatus(
                cloudAccount.getStatus());

        dto.setCreatedAt(
                cloudAccount.getCreatedAt());

        return dto;
    }
}