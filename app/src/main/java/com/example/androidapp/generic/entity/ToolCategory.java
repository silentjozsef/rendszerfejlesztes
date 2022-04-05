package com.example.androidapp.generic.entity;

import com.example.androidapp.generic.enumeration.MaintenanceInterval;

public class ToolCategory {

    private Long id;

    private String category;

    private MaintenanceInterval maintenanceInterval;

    private String description;

    private ToolCategory parentCategory;

    public ToolCategory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MaintenanceInterval getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public void setMaintenanceInterval(MaintenanceInterval maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToolCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ToolCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "ToolCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", maintenanceInterval=" + maintenanceInterval +
                ", description='" + description + '\'' +
                ", parentCategory=" + parentCategory +
                '}';
    }
}
