package com.example.androidapp.generic.query;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidapp.MySingleton;
import com.example.androidapp.generic.GlobalGson;
import com.example.androidapp.generic.callback.ErrorCallBack;
import com.example.androidapp.generic.callback.SuccessCallBack;
import com.example.androidapp.generic.request.GenericSingleRequest;
import com.example.androidapp.generic.request.MyJsonObjectRequest;
import com.example.androidapp.generic.response.GenericListResponse;
import com.example.androidapp.generic.response.GenericPageResponse;
import com.example.androidapp.generic.response.GenericSingleResponse;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class BaseQuery<T> {

    protected static final BaseQuery query = new BaseQuery<>();

    protected static final String backendURL = "http://192.168.0.74:8080/";

    protected String parentUrl;
    protected Context context;
    protected String session;


    public BaseQuery() {
    }

    public static BaseQuery get() {
        return query;
    }

    public static BaseQuery get(Context context) {
        query.context = context;
        return query;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        if (!query.equals(this)) {
            query.setSession(session);
        }
        this.session = session;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public void getById(Long id, final SuccessCallBack<GenericSingleResponse> successCallBack, final ErrorCallBack<GenericSingleResponse> errorCallBack) {
        String requestUrl = backendURL + parentUrl + "get-by-id?id=" + id.toString();

        String finalUrl = requestUrl;
        JsonObjectRequest request = new MyJsonObjectRequest(Request.Method.GET, requestUrl, null, null, null, session,
                response -> {
                    GenericSingleResponse genericSingleResponse = getGenericSingleResponse(response.toString());
                    successCallBack.onSuccess(genericSingleResponse);
                },
                error -> {
                    try {
                        String body = null;
                        GenericSingleResponse genericSingleResponse = null;
                        if (error.networkResponse != null && error.networkResponse.data != null) {
                            body = new String(error.networkResponse.data, "UTF-8");
                            genericSingleResponse = getGenericSingleResponse(body);
                        }
                        errorCallBack.onError(genericSingleResponse);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
        );
        sendRequest(request);

    }

    public void list(String search, final SuccessCallBack<GenericListResponse> successCallBack, final ErrorCallBack<GenericListResponse> errorCallBack) {
        String requestUrl = backendURL + parentUrl + "list?search=" + search;

        String finalUrl = requestUrl;
        JsonObjectRequest request = new MyJsonObjectRequest(Request.Method.GET, requestUrl, null, null, null, session,
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

    public void pageable(Long size, Long page, String search, final SuccessCallBack<GenericPageResponse> successCallBack, final ErrorCallBack<GenericPageResponse> errorCallBack) {
        String requestUrl = backendURL + parentUrl + "pageable?size=" + size + "&page=" + page + "&search=" + search;

        String finalUrl = requestUrl;
        JsonObjectRequest request = new MyJsonObjectRequest(Request.Method.GET, requestUrl, null, null, null, session,
                response -> {
                    GenericPageResponse genericPageResponse = getGenericPageResponse(response.toString());
                    successCallBack.onSuccess(genericPageResponse);
                },
                error -> {
                    try {
                        String body = null;
                        GenericPageResponse genericPageResponse = null;
                        if (error.networkResponse != null && error.networkResponse.data != null) {
                            body = new String(error.networkResponse.data, "UTF-8");
                            genericPageResponse = getGenericPageResponse(body);
                        }
                        errorCallBack.onError(genericPageResponse);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
        );
        sendRequest(request);
    }

    public void save(T entity, final SuccessCallBack<GenericSingleResponse> successCallBack, final ErrorCallBack<GenericSingleResponse> errorCallBack) {
        try {
            String requestUrl = backendURL + parentUrl + "save";

            GenericSingleRequest user = new GenericSingleRequest<T>(entity);

            JsonObjectRequest request = new MyJsonObjectRequest(Request.Method.POST, requestUrl, new JSONObject(GlobalGson.get().getGson().toJson(user)), null, null, session,
                    response -> {
                        GenericSingleResponse genericSingleResponse = getGenericSingleResponse(response.toString());
                        successCallBack.onSuccess(genericSingleResponse);
                    },
                    error -> {
                        try {
                            String body = null;
                            GenericSingleResponse genericSingleResponse = null;
                            if (error.networkResponse != null && error.networkResponse.data != null) {
                                body = new String(error.networkResponse.data, "UTF-8");
                                genericSingleResponse = getGenericSingleResponse(body);
                            }
                            Log.d("MY_OUTPUT", "body" + body);
                            errorCallBack.onError(genericSingleResponse);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
            );
            sendRequest(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public BaseQuery setContext(Context context) {
        query.context = context;
        this.context = context;
        return this;
    }

    //generic functions for child classes

    protected GenericSingleResponse getGenericSingleResponse(String json) {
        GenericSingleResponse genericSingleResponse = GlobalGson.get().getGson().fromJson(json, new TypeToken<GenericSingleResponse<T>>() {
        }.getType());
        return genericSingleResponse;
    }

    protected GenericListResponse getGenericListResponse(String json) {
        GenericListResponse genericListResponse = GlobalGson.get().getGson().fromJson(json, new TypeToken<GenericListResponse<T>>() {
        }.getType());
        return genericListResponse;
    }

    protected GenericPageResponse getGenericPageResponse(String json) {
        GenericPageResponse genericPageResponse = GlobalGson.get().getGson().fromJson(json, new TypeToken<GenericPageResponse<T>>() {
        }.getType());
        return genericPageResponse;
    }

    protected void sendRequest(JsonObjectRequest request) {
        request.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
