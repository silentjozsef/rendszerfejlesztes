package com.example.androidapp.generic.response;

import java.util.List;

public class GenericListResponse<T> extends BaseRestResponse {
    private List<T> items;

    public GenericListResponse(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GenericListResponse{" +
                "items=" + items +
                '}';
    }
}
