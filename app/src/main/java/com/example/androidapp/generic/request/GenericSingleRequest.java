package com.example.androidapp.generic.request;


public class GenericSingleRequest<T> {
    private T param;

    public GenericSingleRequest(T param) {
        this.param = param;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}