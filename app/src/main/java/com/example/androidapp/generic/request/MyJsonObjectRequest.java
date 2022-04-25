package com.example.androidapp.generic.request;

import android.annotation.SuppressLint;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyJsonObjectRequest extends JsonObjectRequest {

    private String authToken;
    private String httpSession;

    @SuppressLint("NewApi")
    public MyJsonObjectRequest(
            int method,
            String url,
            @Nullable JSONObject jsonRequest,
            String username, String password, String httpSession,
            Response.Listener<JSONObject> listener,
            @Nullable Response.ErrorListener errorListener) {
        super(
                method,
                url,
                jsonRequest,
                listener,
                errorListener);
        if (username != null && password != null) {
            authToken = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        }
        this.httpSession = httpSession;
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("x-vacationtoken", "secret_token");
        params.put("content-type", "application/json");
        if (authToken != null) {
            params.put("Authorization", "Basic " + authToken);
        }
        if (httpSession != null) {
            params.put("Cookie", "JSESSIONID=" + httpSession);
        }

        return params;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));

            JSONObject jsonResponse = new JSONObject(jsonString);
            jsonResponse.put("headers", response.headers.toString());

            return Response.success(jsonResponse,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }
}
