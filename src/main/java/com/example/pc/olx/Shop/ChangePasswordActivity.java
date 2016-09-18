package com.example.pc.olx.Shop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;
import com.example.pc.olx.User.User;
import com.example.pc.olx.User.UserManager;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText oldPasswordET;
    EditText newPasswordET;
    Button submit1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final String username =intent.getStringExtra("login");
        setContentView(R.layout.activity_change_password);
        oldPasswordET = (EditText) findViewById(R.id.oldPasswordET);
        newPasswordET = (EditText) findViewById(R.id.newPasswordET);
        final String oldPassword = oldPasswordET.getText().toString();
        final String newPassword = newPasswordET.getText().toString();
        submit1Button = (Button) findViewById(R.id.submitButton);
        final User u = UserManager.getInstance(this).getUser(username);

        submit1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!u.getPassword().equals(oldPasswordET.getText().toString())){
                    oldPasswordET.setError("Password mismatch");
                    oldPasswordET.requestFocus();
                    return;
                }
                if (newPasswordET.getText().toString().length() < 6) {
                    newPasswordET.setError("Password must be more than 6 symbols.");
                    newPasswordET.requestFocus();
                    return;
                }

                UserManager.getInstance(ChangePasswordActivity.this).changePassword(ChangePasswordActivity.this,username,newPasswordET.getText().toString());
                finish();

            }
        });






    }
}
