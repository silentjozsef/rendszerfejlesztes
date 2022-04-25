package com.example.androidapp.generic.entity;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueLog {

    private Long id;

    private Long issueId;

    private String description;

    private Instant createdOn;

    public IssueLog(Long id, Long issueId, String description) {
        this.id = id;
        this.issueId = issueId;
        this.description = description;
    }
}
