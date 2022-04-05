package com.example.androidapp.generic.query;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidapp.generic.callback.ErrorCallBack;
import com.example.androidapp.generic.callback.SuccessCallBack;
import com.example.androidapp.generic.GlobalGson;
import com.example.androidapp.generic.entity.User;
import com.example.androidapp.generic.request.GenericSingleRequest;
import com.example.androidapp.generic.response.GenericSingleResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class UserQuery extends BaseQuery<User> {

    private static final UserQuery query = new UserQuery();

    public static UserQuery get() {
        return query;
    }

    private static final String url = "user/";

    private UserQuery() {
        super(url, null);
    }

    public void login(String username, String password, final SuccessCallBack<GenericSingleResponse> successCallBack, final ErrorCallBack<GenericSingleResponse> errorCallBack) {
        try {
            String requestUrl = backendURL + parentUrl + "login";

            GenericSingleRequest user = new GenericSingleRequest<User>(new User(username, password));

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, requestUrl, new JSONObject(GlobalGson.get().getGson().toJson(user)),
                    response -> {
                        GenericSingleResponse genericSingleResponse = getGenericSingleResponse(response.toString());
                        successCallBack.onSuccess(genericSingleResponse);
                    },
                    error -> {
                        try {
                            String body = null;
                            GenericSingleResponse genericSingleResponse = null;
                            if (error.networkResponse.data != null) {
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

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getById(Long id, SuccessCallBack<GenericSingleResponse> successCallBack, ErrorCallBack<GenericSingleResponse> errorCallBack) throws Exception {
        throw new Exception("NOT_SUPPORTED");
    }

    @Override
    public UserQuery setContext(Context context) {
        this.context = context;
        return this;
    }
}
