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


    public static ToolQuery get() {
        ToolQuery toolQuery = new ToolQuery();
        toolQuery.context = query.context;
        toolQuery.parentUrl = url;
        toolQuery.session = query.session;
        return toolQuery;
    }

    public static ToolQuery get(Context context) {
        ToolQuery toolQuery = new ToolQuery();
        toolQuery.context = context;
        toolQuery.parentUrl = url;
        toolQuery.session = query.session;
        return toolQuery;
    }
    private static final String url = "tool/";

    @Override
    public ToolQuery setContext(Context context) {
        return (ToolQuery)super.setContext(context);
    }

}
