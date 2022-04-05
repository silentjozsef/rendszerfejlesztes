package com.example.androidapp.generic.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GenericPageResponse<T> extends BaseRestResponse {
    private Page<T> page;

    @Override
    public String toString() {
        return "GenericPageResponse{" +
                "status='" + status + '\'' +
                ", cause='" + cause + '\'' +
                ", page=" + page +
                '}';
    }
}
