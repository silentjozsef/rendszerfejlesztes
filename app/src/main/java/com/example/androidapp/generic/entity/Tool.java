package com.example.androidapp.generic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tool {
    private Long id;

    private String name;

    private String identifier;

    private String description;

    private ToolCategory toolCategory;
}
