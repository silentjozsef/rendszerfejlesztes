package com.example.androidapp.generic.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum IssueStatus {
    NEW,
    SCHEDULED,
    ACCEPTED,
    DECLINED,
    STARTED,
    COMPLETED;

    private String category;
}