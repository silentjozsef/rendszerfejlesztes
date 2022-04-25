package com.example.androidapp.generic.query;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidapp.generic.GlobalGson;
import com.example.androidapp.generic.callback.ErrorCallBack;
import com.example.androidapp.generic.callback.SuccessCallBack;
import com.example.androidapp.generic.entity.User;
import com.example.androidapp.generic.request.GenericSingleRequest;
import com.example.androidapp.generic.request.MyJsonObjectRequest;
import com.example.androidapp.generic.response.GenericSingleResponse;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.SneakyThrows;

public class UserQuery extends BaseQuery<User> {

    public static UserQuery get() {
        UserQuery userQuery = new UserQuery();
        userQuery.context = query.context;
        userQuery.parentUrl = url;
        userQuery.session = query.session;
        return userQuery;
    }

    public static UserQuery get(Context context) {
        UserQuery userQuery = new UserQuery();
        userQuery.context = context;
        userQuery.parentUrl = url;
        userQuery.session = query.session;
        return userQuery;
    }

    @Override
    public UserQuery setContext(Context context) {
        return (UserQuery) super.setContext(context);
    }

    private static final String url = "user/";


    public void login(String username, String password, final SuccessCallBack<GenericSingleResponse> successCallBack, final ErrorCallBack<GenericSingleResponse> errorCallBack) {
        try {
            String requestUrl = backendURL + parentUrl + "login";

            GenericSingleRequest user = new GenericSingleRequest<User>(new User(username, password));

            JsonObjectRequest request = new MyJsonObjectRequest(Request.Method.POST, requestUrl, new JSONObject(GlobalGson.get().getGson().toJson(user)), username, password, null,
                    response -> {
                        //set session
                        GenericSingleResponse genericSingleResponse = getGenericSingleResponse(response.toString());
                        Matcher matcher = Pattern.compile("(JSESSIONID=)([^ ]+)").matcher(genericSingleResponse.getHeaders());
                        if (matcher.find())
                            setSession(matcher.group(2));
                        //callback
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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout(final SuccessCallBack<GenericSingleResponse> successCallBack, final ErrorCallBack<GenericSingleResponse> errorCallBack) {
        try {
            String requestUrl = backendURL + parentUrl + "logout";

            JsonObjectRequest request = new MyJsonObjectRequest(Request.Method.POST, requestUrl, null, null, null, session,
                    response -> {
                        GenericSingleResponse genericSingleResponse = getGenericSingleResponse(response.toString());
                        //callback
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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SneakyThrows
    @Override
    public void getById(Long id, SuccessCallBack<GenericSingleResponse> successCallBack, ErrorCallBack<GenericSingleResponse> errorCallBack) {
        throw new Exception("NOT_SUPPORTED");
    }
}
