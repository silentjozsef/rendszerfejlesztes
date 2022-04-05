package com.example.androidapp.generic.callback;

public interface ErrorCallBack<T> {
    void onError( T errorResponse);
}