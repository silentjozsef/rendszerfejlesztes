package com.example.androidapp.generic.enumeration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum UserType {
    ADMIN,
    TOOL_MANAGER,
    OPERATOR,
    REPAIRMAN;

    private String category;
}