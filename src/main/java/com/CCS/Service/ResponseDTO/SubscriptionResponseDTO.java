package com.CCS.Service.ResponseDTO;

import com.CCS.Service.Enumuration.SubscriptionPlan;

import lombok.Data;

@Data
public class SubscriptionResponseDTO {

    private Long subscriptionId;

    private SubscriptionPlan planName;

    private Double price;

    private Integer maxResources;
}