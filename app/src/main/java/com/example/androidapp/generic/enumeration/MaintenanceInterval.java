package com.example.androidapp.generic.enumeration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum MaintenanceInterval {
    WEEK,
    MONTH,
    QUARTER,
    HALF_YEAR,
    YEAR;

    private String category;
}