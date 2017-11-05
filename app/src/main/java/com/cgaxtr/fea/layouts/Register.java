package com.cgaxtr.fea.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cgaxtr.fea.R;

public class Register extends AppCompatActivity {

    private Button login, register;
    private EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
    }

    private void initUI(){
        this.register = (Button)findViewById(R.id.btnRegRegister);

        this.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conexion a API
            }
        });

        this.login = (Button)findViewById(R.id.btnLinkToLoginScreen);

        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Login.class);
                startActivity(i);
            }
        });
        this.username = (EditText)findViewById(R.id.reg_username);
        this.email = (EditText)findViewById(R.id.reg_email);
        this.password = (EditText)findViewById(R.id.reg_password);
    }
}
