package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserGUI extends AppCompatActivity {

    EditText itemdescedit, itemnameedit, itemidenedit, itemcategedit;
    Button itembtn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_gui);

        itemdescedit = findViewById(R.id.itemidescedit);
        itemnameedit = findViewById(R.id.itemnameedit);
        itemidenedit = findViewById(R.id.itemidenedit);
        itemcategedit = findViewById(R.id.itemcategedit);
        itembtn = findViewById(R.id.itembtn);
        tv = findViewById(R.id.textView);

        final DataService dataService = new DataService(this);

        itembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                JSONObject tooldata = new JSONObject();
//                String string2 = "{id: " + itemcategedit.getText().toString() + ", category: testCategory,maintenanceInterval: WEEK,description: description,parentCategory: null}";
//
//                String string = "name: " + itemnameedit.getText().toString() + ", identifier: " + itemidenedit.getText().toString() + ", description: " + itemdescedit.getText().toString() + ", toolCategory : " + string2 ;
//
//                JSONArray array = new JSONArray();
//
//                try {
//                    //Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
//                    //JSONArray array = new JSONArray();
//                    //tooldata = array.getJSONObject(0);
//                    //JSONObject seged = tooldata.getJSONObject("param");
//                    array.put(string);
//
//
//                    tooldata.put("param", array);
//                    //array.toJSONObject(array);
//                    //Toast.makeText(UserGUI.this, array.toString(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(UserGUI.this, tooldata.toString(), Toast.LENGTH_SHORT).show();
//                    //Toast.makeText(UserGUI.this, array.toString(), Toast.LENGTH_SHORT).show();
//                    //Toast.makeText(UserGUI.this, string, Toast.LENGTH_SHORT).show();
//                    //Toast.makeText(UserGUI.this, "hello", Toast.LENGTH_SHORT).show();
//
//                } catch (JSONException jsonException) {
//                    jsonException.printStackTrace();
//                    Toast.makeText(UserGUI.this, jsonException.toString(), Toast.LENGTH_SHORT).show();
//                    tv.setText(jsonException.toString());
//
//                }
                //Toast.makeText(UserGUI.this, "hello", Toast.LENGTH_SHORT).show();
                dataService.addTool(itemnameedit.getText().toString(),itemidenedit.getText().toString(), itemdescedit.getText().toString()
                                    , itemcategedit.getText().toString(), new DataService.VolleySendListener() {
                            @Override
                            public void onsaveError(String message) {
                                Toast.makeText(UserGUI.this, "baj van", Toast.LENGTH_SHORT).show();
                                tv.setText(message);
                            }

                            @Override
                            public void onResponse(JSONObject item) {
                                Toast.makeText(UserGUI.this, item.toString(), Toast.LENGTH_SHORT).show();

                            }
                        });
                //Toast.makeText(UserGUI.this, "gomb", Toast.LENGTH_SHORT).show();

            }
        });

            }
}