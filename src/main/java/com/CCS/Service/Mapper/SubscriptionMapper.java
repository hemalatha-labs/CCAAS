package com.CCS.Service.Mapper;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.SubscriptionRequestDTO;
import com.CCS.Service.ResponseDTO.SubscriptionResponseDTO;
import com.CCS.Service.model.Subscription;

@Component
public class SubscriptionMapper {

    // RequestDTO → Entity
    public Subscription toEntity(SubscriptionRequestDTO dto) {

        Subscription subscription = new Subscription();

        subscription.setPlanName(dto.getPlanName());

        // Get price from enum
        subscription.setPrice(
                (double) dto.getPlanName().getPrice()
        );

        // Get maximum resources from enum
        subscription.setMaxResources(
                dto.getPlanName().getMaxResources()
        );

        return subscription;
    }


    // Entity → ResponseDTO
    public SubscriptionResponseDTO toResponseDTO(
            Subscription subscription) {

        SubscriptionResponseDTO dto =
                new SubscriptionResponseDTO();

        dto.setSubscriptionId(
                subscription.getSubscriptionId()
        );

        dto.setPlanName(
                subscription.getPlanName()
        );

        dto.setPrice(
                subscription.getPrice()
        );

        dto.setMaxResources(
                subscription.getMaxResources()
        );

        return dto;
    }
}