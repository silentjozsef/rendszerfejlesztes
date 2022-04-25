package com.example.androidapp.generic.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRestResponse {
    protected String status;
    protected String cause;
    protected String headers;
}
