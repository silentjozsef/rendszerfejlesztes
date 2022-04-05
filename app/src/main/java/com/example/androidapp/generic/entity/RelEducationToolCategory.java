package com.example.androidapp.generic.entity;


public class RelEducationToolCategory {
    private Long id;

    private Education education;

    private ToolCategory toolCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public ToolCategory getToolCategory() {
        return toolCategory;
    }

    public void setToolCategory(ToolCategory toolCategory) {
        this.toolCategory = toolCategory;
    }

    @Override
    public String toString() {
        return "RelEducationToolCategory{" +
                "id=" + id +
                ", education=" + education +
                ", toolCategory=" + toolCategory +
                '}';
    }
}
