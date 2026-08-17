package com.CCS.Service.ResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

import com.CCS.Service.Enumuration.IndustryType;
import com.CCS.Service.Enumuration.SubscriptionPlan;
import com.CCS.Service.Enumuration.TenantStatus;

import lombok.Data;

@Data
public class TenantResponseDTO {

    private UUID tenantId;

    private String tenantName;

    private IndustryType industry;

    private SubscriptionPlan subscriptionPlan;

    private TenantStatus status;

    private LocalDateTime createdAt;
}