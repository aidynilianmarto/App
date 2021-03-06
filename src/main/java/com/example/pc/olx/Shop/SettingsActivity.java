package com.example.pc.olx.Shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pc.olx.User.ChangeAddressActivity;
import com.example.pc.olx.R;
import com.example.pc.olx.User.ChangePhoneActivity;

public class SettingsActivity extends AppCompatActivity {
    Button changePasswordBtn;
    Button changeEmailBtn;
    Button changeAddressBtn;
    Button changePhoneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        changeAddressBtn = (Button) findViewById(R.id.changeAddress);
        changeEmailBtn = (Button) findViewById(R.id.changeEmail);
        changePasswordBtn = (Button) findViewById(R.id.changePassword);
        changePhoneBtn = (Button) findViewById(R.id.change_phone);
        Intent intent = getIntent();
        final String username =intent.getStringExtra("login");
        changeAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangeAddressActivity.class);
                intent.putExtra("login",username);
                startActivity(intent);
                finish();
            }
        });

        changeEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangeEmailActivity.class);
                intent.putExtra("login",username);
                startActivity(intent);
                finish();
            }
        });

        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                intent.putExtra("login",username);
                startActivity(intent);
                finish();
            }
        });

        changePhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, ChangePhoneActivity.class);
                intent.putExtra("login",username);
                startActivity(intent);
                finish();
            }
        });
    }
}
