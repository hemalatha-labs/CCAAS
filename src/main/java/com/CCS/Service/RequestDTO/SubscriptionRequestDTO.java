package com.CCS.Service.RequestDTO;

import com.CCS.Service.Enumuration.SubscriptionPlan;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubscriptionRequestDTO {

    @NotNull(message = "Subscription plan is required")
    private SubscriptionPlan planName;
}