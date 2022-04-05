package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidapp.generic.entity.Tool;
import com.example.androidapp.generic.entity.ToolCategory;
import com.example.androidapp.generic.query.RelEducationToolCategoryQuery;
import com.example.androidapp.generic.query.ToolCategoryQuery;
import com.example.androidapp.generic.query.ToolQuery;
import com.example.androidapp.generic.query.UserQuery;

public class MainActivity extends AppCompatActivity {
    EditText usernameedit, passwordedit;
    Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameedit = findViewById(R.id.usernameedit);
        passwordedit = findViewById(R.id.passwordedit);
        loginbtn = findViewById(R.id.loginbtn);
        
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pélad toolSave
//                ToolQuery.get().setContext(MainActivity.this).save(
//                    new Tool(null, "mobil", "mibilAzon", "leírás", new ToolCategory(1L)),
//                    response -> {
//                        Log.d("MY_OUTPUT", "response: " + response);
//                    }, errorResponse -> {
//                        Log.d("MY_OUTPUT", "errorResponse: " + errorResponse);
//                    }
//                );

                UserQuery.get().setContext(MainActivity.this).login(
                        usernameedit.getText().toString(), passwordedit.getText().toString(),
                        response -> {
                            Log.d("MY_OUTPUT", "response: " + response);
                        }, errorResponse -> {
                            Log.d("MY_OUTPUT", "errorResponse: " + errorResponse);
                        }
                );

            }
        });

    }

}