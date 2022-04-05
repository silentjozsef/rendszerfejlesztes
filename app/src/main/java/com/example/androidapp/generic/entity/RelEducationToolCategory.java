package com.example.androidapp.generic.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelEducationToolCategory {
    private Long id;

    private Education education;

    private ToolCategory toolCategory;
}
