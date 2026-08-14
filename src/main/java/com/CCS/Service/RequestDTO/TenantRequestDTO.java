package com.CCS.Service.RequestDTO;

import com.CCS.Service.Enumuration.IndustryType;
import com.CCS.Service.Enumuration.SubscriptionPlan;
import com.CCS.Service.Enumuration.TenantStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TenantRequestDTO {

    @NotBlank(message = "Tenant name is required")
    private String tenantName;

    @NotNull(message = "Industry is required")
    private IndustryType industry;

    @NotNull(message = "Subscription plan is required")
    private SubscriptionPlan subscriptionPlan;

    @NotNull(message = "Status is required")
    private TenantStatus status;
}
