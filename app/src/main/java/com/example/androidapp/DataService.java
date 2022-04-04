package com.example.androidapp;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataService {

    public static final String URLlink = "http://192.168.0.101:8080/user/list?search=username=";
    public static final String URLsave = "http://192.168.0.101:8080/tool/save";

    JSONObject tooldata = new JSONObject();

    Context context;

    public DataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(boolean yes);
    }

    public interface VolleySendListener {
        void onsaveError(String message);

        void onResponse(JSONObject data);
    }

    public void login(String username, String password, VolleyResponseListener volleyResponseListener) {
        //localhost:8080/user/login?search=username=admin&search=password=admin
        String url = "http://192.168.0.105:8080/user/login?username="+username+"&password="+password;

        JsonArrayRequest request= new JsonArrayRequest(Request.Method.POST, url,null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(context,"sikeres belépés",Toast.LENGTH_LONG).show();
                        Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                        boolean yes = false;
                        try {

                            Map<String,String> data = new HashMap<>();
                            data.put(response.getString(0), response.getString(1));

                            for (Map.Entry<String, String> it : data.entrySet()) {
                                if (it.getKey() == username && it.getValue() == password) {
                                    yes = true;
                                }
                            }

                            if (response.getString(0) == username && response.getString(1) == password) {
                                    yes = true;
                                }

                            Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                            volleyResponseListener.onResponse(yes);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
                request.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                MySingleton.getInstance(context).addToRequestQueue(request);

    }


    /*public void login2(String valami, VolleyResponseListener volleyResponseListener) {
        String url = URLlink +valami ;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    boolean yes = false;

                    JSONArray items = response.getJSONArray("items");
                    LoginData first = new LoginData();

                    JSONObject first_data = (JSONObject) items.get(0);

                    first.setId(first_data.getInt("id"));
                    first.setUsername(first_data.getString("username"));
                    first.setUserType(first_data.getString("userType"));
                    first.setEducations(first_data.getString("educations"));

                    if (first.getUsername() != null) {
                        yes = true;
                    }

                    volleyResponseListener.onResponse(yes);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError(error.toString());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }*/

//    {
//        "param": {
//        "name" : "testTool2",
//                "identifier" : "tool-0002",
//                "description": "testTool",
//                "toolCategory": {
//                    "id": 1,
//                    "category": "testCategory",
//                    "maintenanceInterval": "WEEK",
//                    "description": "description",
//                    "parentCategory": null
//                    }
//                }
//    }

    public void addTool(String name, String identifier, String description, String id, VolleySendListener volleySendListener) {
        JsonObjectRequest saverequest = new JsonObjectRequest(Request.Method.POST, URLsave, tooldata, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                JSONObject tooldata = new JSONObject();

                String string2 = "{id: " + id + ", category: testCategory,maintenanceInterval: WEEK,description: description,parentCategory: null}";
                String string = "name: " + name + ", identifier: " + identifier + ", description: " + description + ", toolCategory : " + string2 ;

                JSONArray array = new JSONArray();
                array.put(string);
                try {
                    tooldata.put("item", array);
                    //Toast.makeText(context, tooldata.toString(), Toast.LENGTH_SHORT).show();

                } catch (JSONException jsonException) {
                    jsonException.printStackTrace();
                }
                volleySendListener.onResponse(tooldata);
            }
            }, new Response.ErrorListener(){
                public void onErrorResponse (VolleyError error){
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                volleySendListener.onsaveError(error.toString());
                error.printStackTrace();
                }
            }
        );
        MySingleton.getInstance(context).addToRequestQueue(saverequest);
    }
}
