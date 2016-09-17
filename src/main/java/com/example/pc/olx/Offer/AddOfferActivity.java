package com.example.pc.olx.Offer;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pc.olx.R;
import com.example.pc.olx.Shop.Shop;
import com.example.pc.olx.User.UserHomeActivity;
import com.example.pc.olx.User.UserManager;

import java.util.ArrayList;

public class AddOfferActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner stateSpinner;
    private EditText titleET;
    private EditText descET;
    private EditText priceET;
    private EditText locationET;
    private Button addOfferButton;
    private ImageView offerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);


        Intent intent = getIntent();
        final String loggedUser = intent.getStringExtra("login");

        offerImage = (ImageView) findViewById(R.id.offer_image);
        addOfferButton = (Button) findViewById(R.id.add_offer_button);
        titleET = (EditText) findViewById(R.id.offer_title);
        descET = (EditText) findViewById(R.id.offer_description);
        priceET = (EditText) findViewById(R.id.offer_price);
        locationET = (EditText) findViewById(R.id.offer_location);
        stateSpinner = (Spinner) findViewById(R.id.state);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this, R.array.State, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int x = position;
                switch(x){
                    case 0:
                        ArrayAdapter<CharSequence> ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Real_estate, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 1:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Cars_and_parts, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 2:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Electronics, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 3:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Sport_hobby_books, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 4:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Animals, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 5:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Home_garden, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 6:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Fashion, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                    case 7:
                        ada = ArrayAdapter.createFromResource(AddOfferActivity.this, R.array.Baby_Children, android.R.layout.simple_spinner_item);
                        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(ada);
                        return;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titleET.getText().toString()==null||titleET.getText().toString().isEmpty()){
                    titleET.setError("This field is mandatory");
                    titleET.requestFocus();
                    return;
                }
                if(descET.getText().toString()==null||descET.getText().toString().isEmpty()){
                    descET.setError("This field is mandatory");
                    descET.requestFocus();
                    return;
                }
                if(priceET.getText().toString()==null||priceET.getText().toString().isEmpty()){
                    priceET.setError("This field is mandatory");
                    priceET.requestFocus();
                    return;
                }
                if(locationET.getText().toString()==null||locationET.getText().toString().isEmpty()){
                    locationET.setError("This field is mandatory");
                    locationET.requestFocus();
                    return;
                }

                Offer.State state = null;

                String x = stateSpinner.getSelectedItem().toString();
                switch(x){
                    case "USED":
                        state = Offer.State.USED;
                        break;
                    case "NEW":
                        state = Offer.State.NEW;
                        break;
                }
                int pic = R.drawable.island1;

                Offer offer = new Offer(titleET.getText().toString(), Double.parseDouble(priceET.getText().toString()), descET.getText().toString(), locationET.getText().toString(), pic, state, spinner2.getSelectedItem().toString());
                offer.setUser(UserManager.getInstance(AddOfferActivity.this).getUser(loggedUser));

                Shop.getInstance().addOffer(offer);
                Toast.makeText(AddOfferActivity.this, "The offer has been added", Toast.LENGTH_SHORT).show();

                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddOfferActivity.this, UserHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
