package com.example.pc.olx.Shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;

public class ChangeEmailActivity extends AppCompatActivity {
    EditText oldEmailET;
    EditText newEmailET;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        oldEmailET = (EditText) findViewById(R.id.oldEmailET);
        newEmailET = (EditText) findViewById(R.id.newEmailET);
        submitButton = (Button) findViewById(R.id.submitButton);
        String oldEmail = oldEmailET.getText().toString();
        String newEmail = oldEmailET.getText().toString();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
