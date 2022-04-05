package com.example.androidapp.generic.query;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidapp.generic.GlobalGson;
import com.example.androidapp.generic.callback.ErrorCallBack;
import com.example.androidapp.generic.callback.SuccessCallBack;
import com.example.androidapp.generic.entity.Tool;
import com.example.androidapp.generic.entity.User;
import com.example.androidapp.generic.request.GenericSingleRequest;
import com.example.androidapp.generic.response.GenericSingleResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class ToolQuery extends BaseQuery<Tool> {

    private static final ToolQuery query = new ToolQuery();

    public static ToolQuery get() {
        return query;
    }

    private static final String url = "tool/";

    private ToolQuery() {
        super(url, null);
    }

    private ToolQuery(Context context) {
        super(url, context);
    }




    @Override
    public ToolQuery setContext(Context context) {
        this.context = context;
        return this;
    }





}
