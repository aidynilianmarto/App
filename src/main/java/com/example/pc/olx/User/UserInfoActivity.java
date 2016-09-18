package com.example.pc.olx.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pc.olx.R;

public class UserInfoActivity extends AppCompatActivity {
    private TextView usernameTV;
    private TextView nameTV;
    private TextView addressTV;
    private TextView emailTV;
    private TextView phoneTV;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        usernameTV = (TextView) findViewById(R.id.user_username);
        nameTV = (TextView) findViewById(R.id.user_name);
        addressTV = (TextView) findViewById(R.id.user_address);
        emailTV = (TextView) findViewById(R.id.user_email);
        phoneTV = (TextView) findViewById(R.id.user_phone);
        username = getIntent().getStringExtra("login");
        User u = UserManager.getInstance(this).getUser(username);
        usernameTV.setText(u.getUsername());
        nameTV.setText(u.getName());
        addressTV.setText(u.getAddress());
        emailTV.setText(u.getEmail());
        phoneTV.setText(u.getPhone());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
