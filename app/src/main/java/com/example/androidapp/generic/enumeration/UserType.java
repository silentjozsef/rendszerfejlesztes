package com.example.androidapp.generic.enumeration;


public enum UserType {
    ADMIN,
    TOOL_MANAGER,
    OPERATOR,
    REPAIRMAN;

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "category='" + category + '\'' +
                '}';
    }
}