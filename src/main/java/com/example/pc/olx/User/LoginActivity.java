package com.example.pc.olx.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.olx.Offer.AddOfferActivity;
import com.example.pc.olx.Shop.HomeActivity;
import com.example.pc.olx.R;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        final String logged = intent.getStringExtra("login");


        username = (EditText) findViewById(R.id.editTxtUsernameLog);
        password = (EditText) findViewById(R.id.editTxtPasswordLog);
        login = (Button) findViewById(R.id.buttonLogin);
        register = (Button) findViewById(R.id.btnRegister);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!UserManager.getInstance(LoginActivity.this).isLogin(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Sorry, user with that username and password doesn't exist!", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                    return;
                }

                if(logged.equals("notlogged")){
                    Intent intent = new Intent(LoginActivity.this, AddOfferActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(LoginActivity.this, UserHomeActivity.class);
                    intent.putExtra("logUser",username.getText().toString());
                    startActivity(intent);
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                username.setError(null);
                password.setError(null);
                startActivity(intent2);
            }
        });


    }
}

