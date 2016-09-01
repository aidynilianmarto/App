package com.example.pc.olx.Shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olx.ChangeAddressActivity;
import com.example.pc.olx.R;

public class SettingsActivity extends AppCompatActivity {
    Button changePasswordBtn;
    Button changeEmailBtn;
    Button changeAddressBtn;
    Button removeAccountBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        changeAddressBtn = (Button) findViewById(R.id.changeAddress);
        changeEmailBtn = (Button) findViewById(R.id.changeEmail);
        changePasswordBtn = (Button) findViewById(R.id.changePassword);
        removeAccountBtn = (Button) findViewById(R.id.deleteAccount);

        changeAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangeAddressActivity.class);
                startActivity(intent);
                finish();
            }
        });

        changeEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangeEmailActivity.class);
                startActivity(intent);
                finish();
            }
        });

        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        removeAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
