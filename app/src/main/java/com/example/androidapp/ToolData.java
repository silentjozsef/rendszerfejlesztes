package com.example.androidapp;

public class ToolData {

//    {
//        "param": {
//                "name" : "testTool2",
//                "identifier" : "tool-0002",
//                "description": "testTool",
//                "toolCategory": {
//            "id": 1,
//                    "category": "testCategory",
//                    "maintenanceInterval": "WEEK",
//                    "description": "description",
//                    "parentCategory": null
//        }
//    }
//    }

    private String name;
    private String identifier;
    private String description;
    private int toolcategory;

    public ToolData() {
    }

    public ToolData(String name, String identifier, String description, int toolcategory) {
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.toolcategory = toolcategory;
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

    public int getToolcategory() {
        return toolcategory;
    }

    public void setToolcategory(int toolcategory) {
        this.toolcategory = toolcategory;
    }

}
