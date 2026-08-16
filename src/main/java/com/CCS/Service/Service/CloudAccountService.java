package com.CCS.Service.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.CloudAccountMapper;
import com.CCS.Service.Repo.CloudAccountRepo;
import com.CCS.Service.RequestDTO.CloudAccountRequestDTO;
import com.CCS.Service.ResponseDTO.CloudAccountResponseDTO;
import com.CCS.Service.Validation.CloudAccountValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.CloudAccount;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudAccountService {

    @Autowired
    private CloudAccountRepo cloudAccountRepo;

    @Autowired
    private CloudAccountMapper cloudAccountMapper;

    @Autowired
    private CloudAccountValidator cloudAccountValidator;


    // GET ALL
    public List<CloudAccountResponseDTO> getAllCloudAccounts() {

        return cloudAccountRepo.findAll()
                .stream()
                .map(cloudAccountMapper::toResponseDTO)
                .toList();
    }


    // GET BY ID
    public CloudAccountResponseDTO getCloudAccount(UUID id) {

        CloudAccount cloudAccount =
                cloudAccountRepo.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cloud account not found with id: " + id
                                ));

        return cloudAccountMapper.toResponseDTO(cloudAccount);
    }


    // CREATE
    public CloudAccountResponseDTO newCloudAccount(
            CloudAccountRequestDTO dto) {

        cloudAccountValidator.validate(dto);

        CloudAccount cloudAccount =
                cloudAccountMapper.toEntity(dto);

        CloudAccount savedCloudAccount =
                cloudAccountRepo.save(cloudAccount);

        return cloudAccountMapper.toResponseDTO(
                savedCloudAccount);
    }


    // UPDATE
    public CloudAccountResponseDTO updateCloudAccount(
            UUID id,
            CloudAccountRequestDTO dto) {

        cloudAccountValidator.validate(dto);

        CloudAccount existingCloudAccount =
                cloudAccountRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud account not found with id: " + id));

        existingCloudAccount.setAccountName(
                dto.getAccountName());

        existingCloudAccount.setAccountIdentifier(
                dto.getAccountIdentifier());

        existingCloudAccount.setProvider(
                dto.getProvider());

        existingCloudAccount.setRegion(
                dto.getRegion());

        CloudAccount updatedCloudAccount =
                cloudAccountRepo.save(
                        existingCloudAccount);

        return cloudAccountMapper.toResponseDTO(
                updatedCloudAccount);
    }


    // DELETE
    public void deleteCloudAccount(UUID id) {

        CloudAccount cloudAccount =
                cloudAccountRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cloud account not found with id: " + id));

        cloudAccountRepo.delete(cloudAccount);
    }
}