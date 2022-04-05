package com.example.androidapp.generic.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GenericSingleResponse<T> extends BaseRestResponse {
    private T item;

    @Override
    public String toString() {
        return "GenericSingleResponse{" +
                "status='" + status + '\'' +
                ", cause='" + cause + '\'' +
                ", item=" + item +
                '}';
    }
}