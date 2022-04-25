package com.example.androidapp.generic.query;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidapp.generic.callback.ErrorCallBack;
import com.example.androidapp.generic.callback.SuccessCallBack;
import com.example.androidapp.generic.entity.Education;
import com.example.androidapp.generic.response.GenericListResponse;

import java.io.UnsupportedEncodingException;

public class EducationQuery extends BaseQuery<Education> {

    public static EducationQuery get() {
        EducationQuery educationQuery = new EducationQuery();
        educationQuery.context = query.context;
        educationQuery.parentUrl = url;
        educationQuery.session = query.session;
        return educationQuery;
    }

    public static EducationQuery get(Context context) {
        EducationQuery educationQuery = new EducationQuery();
        educationQuery.context = context;
        educationQuery.parentUrl = url;
        educationQuery.session = query.session;
        return educationQuery;
    }

    private static final String url = "education/";

    @Override
    public EducationQuery setContext(Context context) {
        return (EducationQuery) super.setContext(context);
    }

    public void listByToolCategory(Long toolCategoryId, final SuccessCallBack<GenericListResponse> successCallBack, final ErrorCallBack<GenericListResponse> errorCallBack) {
        String requestUrl = backendURL + parentUrl + "list-by-tool-category?id=" + toolCategoryId;

        String finalUrl = requestUrl;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, requestUrl, null,
                response -> {
                    GenericListResponse genericSingleResponse = getGenericListResponse(response.toString());
                    successCallBack.onSuccess(genericSingleResponse);
                },
                error -> {
                    try {
                        String body = null;
                        GenericListResponse genericSingleResponse = null;
                        if (error.networkResponse != null && error.networkResponse.data != null) {
                            body = new String(error.networkResponse.data, "UTF-8");
                            genericSingleResponse = getGenericListResponse(body);
                        }
                        errorCallBack.onError(genericSingleResponse);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
        );
        sendRequest(request);
    }


}
