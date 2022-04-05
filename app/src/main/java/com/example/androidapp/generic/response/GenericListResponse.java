package com.example.androidapp.generic.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GenericListResponse<T> extends BaseRestResponse {
    private List<T> items;

    @Override
    public String toString() {
        return "GenericListResponse{" +
                "status='" + status + '\'' +
                ", cause='" + cause + '\'' +
                ", items=" + items +
                '}';
    }
}
