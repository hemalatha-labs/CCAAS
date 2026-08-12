package com.CCS.Service.RequestDTO;
import com.CCS.Service.Enumuration.IndustryType;
import com.CCS.Service.Enumuration.SubscriptionPlan;
import com.CCS.Service.Enumuration.TenantStatus;

import lombok.Data;
@Data

public class TenantRequestDTO {
	
		    private String tenantName;

		    private IndustryType industry;

		    private SubscriptionPlan subscriptionPlan;

		    private TenantStatus status;

}
