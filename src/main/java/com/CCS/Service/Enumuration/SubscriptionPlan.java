package com.CCS.Service.Enumuration;


public enum SubscriptionPlan {

    FREE(0, 5, 30),
    BASIC(499, 25, 30),
    PROFESSIONAL(999, 100, 90),
    ENTERPRISE(1999, 500, 365);

    private final int price;
    private final int maxResources;
    private final int validityDays;

    SubscriptionPlan(int price, int maxResources, int validityDays) {
        this.price = price;
        this.maxResources = maxResources;
        this.validityDays = validityDays;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public int getValidityDays() {
        return validityDays;
    }
}