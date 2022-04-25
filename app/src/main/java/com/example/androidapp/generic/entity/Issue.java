package com.example.androidapp.generic.entity;

import com.example.androidapp.generic.enumeration.IssueStatus;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

    private Long id;

    private Tool tool;

    private User responsibleUser;

    private Instant dateTime;

    private Integer estimatedTime;

    private String title;

    private String severity;

    private String type;

    private IssueStatus status;

    private String description;

    List<IssueLog> issueLogs;
}
