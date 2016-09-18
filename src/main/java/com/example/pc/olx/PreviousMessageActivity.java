package com.example.pc.olx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PreviousMessageActivity extends AppCompatActivity {

    private TextView titleOfMessageTV;
    private TextView userNameTV;
    private TextView descriptionTV;
    private String titleText;
    private String userNameText;
    private String descText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_message);
        titleOfMessageTV = (TextView) findViewById(R.id.titleOfMessageTV);
        userNameTV = (TextView) findViewById(R.id.userNameTV);
        descriptionTV = (TextView) findViewById(R.id.descriptionOfMessageTV);

        titleOfMessageTV.setText(getIntent().getStringExtra("title"));
        userNameTV.setText(getIntent().getStringExtra("userName"));
        descriptionTV.setText(getIntent().getStringExtra("desc"));
    }
}
