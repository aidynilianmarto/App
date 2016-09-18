package com.example.pc.olx.Shop;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;
import com.example.pc.olx.User.User;
import com.example.pc.olx.User.UserManager;

public class ChangeEmailActivity extends AppCompatActivity {
    EditText oldEmailET;
    EditText newEmailET;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        Intent intent = getIntent();
        final String username =intent.getStringExtra("login");
        oldEmailET = (EditText) findViewById(R.id.oldEmailET);
        newEmailET = (EditText) findViewById(R.id.newEmailET);
        submitButton = (Button) findViewById(R.id.submitButton);
        String oldEmail = oldEmailET.getText().toString();
        final String newEmail = oldEmailET.getText().toString();
        final User u = UserManager.getInstance(this).getUser(username);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!u.getEmail().equals(oldEmailET.getText().toString())){
                    oldEmailET.setError("Email mismatch");
                    oldEmailET.requestFocus();
                    return;
                }
                if (newEmailET.getText().toString().isEmpty()) {
                    newEmailET.setError("Please enter new email");
                    newEmailET.requestFocus();
                    return;
                }
                if (UserManager.isValidEmail(newEmail)) {
                    newEmailET.setError("Please enter valid email");
                    newEmailET.requestFocus();
                    return;
                }

                UserManager.getInstance(ChangeEmailActivity.this).changeEmail(ChangeEmailActivity.this,username,newEmailET.getText().toString());
                finish();

            }
        });
    }
}
