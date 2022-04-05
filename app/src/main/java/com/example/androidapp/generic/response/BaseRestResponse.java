package com.example.androidapp.generic.response;

public class BaseRestResponse {
    protected String status;
    protected String cause;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "BaseRestResponse{" +
                "status='" + status + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
