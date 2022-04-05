package com.example.androidapp.generic.response;

import com.example.androidapp.generic.response.BaseRestResponse;

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

    public GenericSingleResponse(T item) {
        this.item = item;
    }

    public GenericSingleResponse() {
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}