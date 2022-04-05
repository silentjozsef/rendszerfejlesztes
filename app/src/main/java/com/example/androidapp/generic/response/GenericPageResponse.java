package com.example.androidapp.generic.response;



public class GenericPageResponse<T> extends BaseRestResponse {
    private Page<T> page;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "GenericPageResponse{" +
                "status='" + status + '\'' +
                ", cause='" + cause + '\'' +
                ", page=" + page +
                '}';
    }
}
