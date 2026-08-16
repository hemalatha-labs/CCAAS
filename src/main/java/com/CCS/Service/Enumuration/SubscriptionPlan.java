package com.CCS.Service.Enumuration;

public enum SubscriptionPlan {

    FREE(0, 5, 5, 30),
    BASIC(499, 25, 20, 30),
    PROFESSIONAL(999, 100, 100, 90),
    ENTERPRISE(1999, 500, 500, 365);

    private final int price;
    private final int maxResources;
    private final int maxScans;
    private final int validityDays;

    SubscriptionPlan(
            int price,
            int maxResources,
            int maxScans,
            int validityDays) {

        this.price = price;
        this.maxResources = maxResources;
        this.maxScans = maxScans;
        this.validityDays = validityDays;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public int getMaxScans() {
        return maxScans;
    }

    public int getValidityDays() {
        return validityDays;
    }
}