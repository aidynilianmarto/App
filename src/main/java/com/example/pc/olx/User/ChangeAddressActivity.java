package com.example.pc.olx.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;

public class ChangeAddressActivity extends AppCompatActivity {
    EditText oldAddressET;
    EditText newAddressET;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);
        oldAddressET = (EditText) findViewById(R.id.oldAddressET);
        newAddressET = (EditText) findViewById(R.id.newAddressET);
        submitButton = (Button) findViewById(R.id.submitButton);
        String oldEmail = oldAddressET.getText().toString();
        String newEmail = newAddressET.getText().toString();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
