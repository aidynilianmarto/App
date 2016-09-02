package com.example.pc.olx.Shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText oldPasswordET;
    EditText newPasswordET;
    Button submit1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldPasswordET = (EditText) findViewById(R.id.oldPasswordET);
        newPasswordET = (EditText) findViewById(R.id.newPasswordET);
        String oldPassword = oldPasswordET.getText().toString();
        String newPassword = newPasswordET.getText().toString();
        submit1Button = (Button) findViewById(R.id.submitButton);
    }
}
