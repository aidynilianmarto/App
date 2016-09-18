package com.example.pc.olx.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;

public class ChangePhoneActivity extends AppCompatActivity {
    EditText newPhoneET;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone);
            Intent intent = getIntent();
            newPhoneET = (EditText) findViewById(R.id.newPhoneET);
            submitButton = (Button) findViewById(R.id.submitButtonPhone);
            final String username = intent.getStringExtra("login");
            final User u = UserManager.getInstance(this).getUser(username);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (newPhoneET.getText().toString().isEmpty()) {
                        newPhoneET.setError("Please enter a phone number");
                        newPhoneET.requestFocus();
                        return;
                    }
                    if(!UserManager.validate(newPhoneET.getText().toString())){
                        newPhoneET.setError("Please enter a valid phone number");
                        newPhoneET.requestFocus();
                        return;
                    }

                    UserManager.getInstance(ChangePhoneActivity.this).changePhone(ChangePhoneActivity.this, username, newPhoneET.getText().toString());
                    finish();


                }
            });
        }
}
