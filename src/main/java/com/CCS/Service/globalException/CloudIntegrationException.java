package com.CCS.Service.globalException;

public class CloudIntegrationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CloudIntegrationException(String message) {
        super(message);
    }
}