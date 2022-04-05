package com.example.androidapp.generic.enumeration;

public enum MaintenanceInterval {
    WEEK,
    MONTH,
    QUARTER,
    HALF_YEAR,
    YEAR;

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "MaintenanceInterval{" +
                "category='" + category + '\'' +
                '}';
    }
}