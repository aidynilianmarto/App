package com.example.pc.olx.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pc.olx.R;

public class ChangeAddressActivity extends AppCompatActivity {
    EditText newAddressET;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);
        Intent intent = getIntent();
        newAddressET = (EditText) findViewById(R.id.newAddressET);
        submitButton = (Button) findViewById(R.id.submitButton);
        final String newAddress = newAddressET.getText().toString();
        final String username =intent.getStringExtra("login");
        final User u = UserManager.getInstance(this).getUser(username);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newAddressET.getText().toString().isEmpty()) {
                    newAddressET.setError("Please enter new address");
                    newAddressET.requestFocus();
                    return;
                }

                UserManager.getInstance(ChangeAddressActivity.this).changeAddress(ChangeAddressActivity.this,username,newAddressET.getText().toString());
                finish();


            }
        });
    }
}
