package com.example.androidapp.generic.entity;

public class Tool {
    private Long id;

    private String name;

    private String identifier;

    private String description;

    private ToolCategory toolCategory;

    public Tool(Long id, String name, String identifier, String description, ToolCategory toolCategory) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.toolCategory = toolCategory;
    }

    public Tool() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToolCategory getToolCategory() {
        return toolCategory;
    }

    public void setToolCategory(ToolCategory toolCategory) {
        this.toolCategory = toolCategory;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                ", description='" + description + '\'' +
                ", toolCategory=" + toolCategory +
                '}';
    }
}
