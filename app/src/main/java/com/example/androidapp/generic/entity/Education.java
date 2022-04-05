package com.example.androidapp.generic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    private Long id;

    private String name;

    private String description;
}
