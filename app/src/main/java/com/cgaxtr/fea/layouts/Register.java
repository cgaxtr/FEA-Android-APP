package com.cgaxtr.fea.layouts;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cgaxtr.fea.VolleySingleton;
import com.cgaxtr.fea.R;
import com.cgaxtr.fea.model.Player;
import com.cgaxtr.fea.utils.TextValidator;
import com.cgaxtr.fea.utils.URL;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Register extends AppCompatActivity {

    private Button login, register;
    private EditText username, email, password;
    private ProgressBar loading;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d("onCreate", "onCreate");
        initUI();
    }

    private void initUI(){
        this.register = (Button)findViewById(R.id.btnRegRegister);
        this.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
        this.register.addTextChangedListener(new TextValidator(register) {
            @Override
            public void validate(TextView textView, String text) {
                //validate
            }
        });

        this.login = (Button)findViewById(R.id.btnLinkToLoginScreen);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Login.class);
                finish();
                startActivity(i);
            }
        });

        this.login.addTextChangedListener(new TextValidator(login) {
            @Override
            public void validate(TextView textView, String text) {
                //validate
            }
        });
        this.username = (EditText)findViewById(R.id.reg_username);
        this.email = (EditText)findViewById(R.id.reg_email);
        this.password = (EditText)findViewById(R.id.reg_password);
        this.loading = (ProgressBar)findViewById(R.id.reg_loading_spinner);
    }

    private void registerUser(){
        Log.d("register", "registerFunction");

        //validate edittext


        this.player = new Player();

        //debug stuff=======================================
        //String username;
        //String email;
        //String password;
        //username = this.username.getText().toString();
        //email = this.email.getText().toString();
        //hash password
        //password = this.password.getText().toString();

        JSONObject body = new JSONObject();

        //try {
         //   body.put("name", username);
         //   body.put("email", email);
        //} catch (JSONException e) {
        //   e.printStackTrace();
        //}

        //Log.d("tag", body.toString());


        //Player p = new Player();
        //p.setName(this.username.getText().toString());
        //p.setEmail(this.email.getText().toString());
        //----------------------------------
        //Gson g = new Gson();
        //String representation = g.toJson(p);
        //Log.d("JSON", representation);
        //debug stuff=======================================

        JsonObjectRequest registerRequest = new JsonObjectRequest
                (Request.Method.POST, URL.REGISTER_URL, body, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        loading.setVisibility(View.INVISIBLE);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Error Response", "Error: " + error.getMessage());
                        System.out.println(error.toString());
                        Snackbar.make(findViewById(android.R.id.content), "Ups algo salió mal", Snackbar.LENGTH_LONG).show();
                        loading.setVisibility(View.INVISIBLE);
                    }
                }){

            public String getBodyContentType(){
                return "application/json; charset=utf-8";
            }

        };

        VolleySingleton.getInstance(this).getRequestQueue().add(registerRequest);
        this.loading.setVisibility(View.VISIBLE);
    }
}
