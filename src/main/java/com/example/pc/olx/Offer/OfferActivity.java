package com.example.pc.olx.Offer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.olx.R;
import com.example.pc.olx.SendMessageActivity;

public class OfferActivity extends AppCompatActivity {

    private ImageView offerIV;
    private TextView offerTV;
    private TextView descriptionTV;
    private TextView stateTV;
    private TextView locationTV;
    private Button msgButton;
    private Button callButton;
    private final int MESSAGE_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        offerTV = (TextView) findViewById(R.id.offerTV);
        offerIV = (ImageView) findViewById(R.id.offerIV);
        descriptionTV = (TextView) findViewById(R.id.descriptionTV);
        stateTV = (TextView) findViewById(R.id.stateTV);
        locationTV = (TextView) findViewById(R.id.locationTV);
        msgButton = (Button) findViewById(R.id.msgButton);
        callButton = (Button) findViewById(R.id.callButton);

        Intent intent = getIntent();
        final Offer offer = (Offer) intent.getSerializableExtra("offer");

        offerTV.setText(offer.getName());
        offerIV.setImageResource(offer.getMainPhoto());
        descriptionTV.setText(offer.getDescription());
        stateTV.setText(offer.getState().toString());
        locationTV.setText(offer.getLocation());
        callButton.setText(offer.getUser().getPhone());

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + offer.getUser().getPhone()));
                startActivity(intent);
            }
        });

        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfferActivity.this, SendMessageActivity.class);
                intent.putExtra("receiver" , offer.getUser().getName());
                intent.putExtra("sender" , "");
                intent.putExtra("title" ,offer.getName());
                startActivityForResult(intent,MESSAGE_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MESSAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(OfferActivity.this, "Message Send Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
