package com.example.pc.olx.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.olx.MessageActivity;
import com.example.pc.olx.Offer.AddOfferActivity;
import com.example.pc.olx.SendMessageActivity;
import com.example.pc.olx.Shop.HomeActivity;
import com.example.pc.olx.R;
import com.example.pc.olx.Shop.SettingsActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = getIntent();
        final String logged = intent.getStringExtra("login");


        username = (EditText) findViewById(R.id.editTxtUsernameLog);
        password = (EditText) findViewById(R.id.editTxtPasswordLog);
        login = (Button) findViewById(R.id.buttonLogin);
        register = (Button) findViewById(R.id.btnRegister);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().isEmpty()){
                    username.setError("Please enter your username");
                    username.requestFocus();
                    return;
                }
                if(password.getText().toString().isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                    return;
                }

                if (!UserManager.getInstance(LoginActivity.this).isLogin(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Sorry, user with that username and password doesn't exist!", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                    return;
                }

                switch (logged){
                    case "message":
                        Intent intent1 = new Intent(LoginActivity.this,MessageActivity.class);
                        intent1.putExtra("login",username.getText().toString());
                        startActivity(intent1);
                        finish();
                        return;
                    case "addOffer":
                        Intent intent2 = new Intent(LoginActivity.this,AddOfferActivity.class);
                        intent2.putExtra("login",username.getText().toString());
                        startActivity(intent2);
                        finish();
                        return;
                    case "settings":
                        Intent intent3 = new Intent(LoginActivity.this,SettingsActivity.class);
                        intent3.putExtra("login",username.getText().toString());
                        startActivity(intent3);
                        finish();
                        return;
                    case "writeMessage":
                        String receiver = intent.getStringExtra("receiver");
                        String offersTitle = intent.getStringExtra("title");
                        Intent intent4 = new Intent(LoginActivity.this,SendMessageActivity.class);
                        intent4.putExtra("sender",username.getText().toString());
                        intent4.putExtra("receiver" , receiver);
                        intent4.putExtra("title" ,offersTitle);
                        startActivity(intent4);
                        finish();
                        return;
                }
                Intent intent = new Intent(LoginActivity.this,UserHomeActivity.class);
                intent.putExtra("login",username.getText().toString());
                startActivity(intent);
                finish();


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

