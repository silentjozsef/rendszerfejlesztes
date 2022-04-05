package com.example.androidapp.generic.entity;

import com.example.androidapp.generic.enumeration.MaintenanceInterval;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToolCategory {

    private Long id;

    private String category;

    private MaintenanceInterval maintenanceInterval;

    private String description;

    private ToolCategory parentCategory;

    public ToolCategory(Long id) {
        this.id = id;
    }
}
