package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        final DataService dataService = new DataService(MainActivity.this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataService.login(usernameedit.getText().toString(), passwordedit.getText().toString(), new DataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "baj van", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(boolean response) {
                        if(response == true) {
                            Toast.makeText(MainActivity.this, "sikeres belépés", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(MainActivity.this, UserGUI.class);
                            startActivity(myIntent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "fuck", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

//                 dataService.login(usernameedit.getText().toString(), new DataService.VolleyResponseListener() {
//                    @Override
//                    public void onError(String message) {
//                        Toast.makeText(MainActivity.this, "baj van", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(boolean yes) {
//                        //Toast.makeText(MainActivity.this, valami2, Toast.LENGTH_SHORT).show();
//                        if(yes == true) {
//                            Toast.makeText(MainActivity.this, "belépés sikeres", Toast.LENGTH_SHORT).show();
//                            Intent myIntent = new Intent(MainActivity.this, UserGUI.class);
//                            startActivity(myIntent);
//                        }
//                        else if(yes ==false) {
//                            Toast.makeText(MainActivity.this, "hibás felhasználónév", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                String url1 = "http://192.168.0.101:8080/user/list?search=username="+ usernameedit.getText() ;
//
//// Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
//                                txt.setText(response.toString());
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        txt.setText(error.toString());
//                        Toast.makeText(MainActivity.this, "baj van", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                queue.add(stringRequest);

                //Toast.makeText(MainActivity.this, id, Toast.LENGTH_SHORT).show();
            }
        });

    }

}