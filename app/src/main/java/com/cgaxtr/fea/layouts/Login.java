package com.cgaxtr.fea.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.cgaxtr.fea.R;

public class Login extends AppCompatActivity {

    private Button login, register;
    private EditText email, password;
    private CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI(){
        this.login = (Button)findViewById(R.id.btnLogin);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        this.register = (Button)findViewById(R.id.btnLinkToRegisterScreen);
        this.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Register.class);
                finish();
                startActivity(i);
            }
        });

        this.email = (EditText)findViewById(R.id.email);
        this.password = (EditText)findViewById(R.id.password);
        this.remember = (CheckBox)findViewById(R.id.remember);
    }
}
