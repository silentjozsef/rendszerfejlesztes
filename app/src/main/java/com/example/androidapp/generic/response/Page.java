package com.example.androidapp.generic.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private List<T> content;
    private Long size;
    private Long totalElements;
    private Long totalPages;
    private Long numberOfElements;
}
