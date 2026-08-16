package com.CCS.Service.Validation;

import org.springframework.stereotype.Component;

import com.CCS.Service.RequestDTO.SubscriptionRequestDTO;
import com.CCS.Service.globalException.BadRequestException;

@Component
public class SubscriptionValidator {

    public void validate(SubscriptionRequestDTO dto) {

        if (dto == null) {

            throw new BadRequestException(
                    "Subscription request cannot be null"
            );
        }

        if (dto.getPlanName() == null) {

            throw new BadRequestException(
                    "Subscription plan is required"
            );
        }
    }
}