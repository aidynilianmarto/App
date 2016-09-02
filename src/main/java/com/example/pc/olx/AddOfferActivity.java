package com.example.pc.olx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.CategoryManager;
import com.example.pc.olx.Offer.Category;
import com.example.pc.olx.Shop.ChangeEmailActivity;

import java.util.ArrayList;
import java.util.List;

public class AddOfferActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);


        Intent intent = getIntent();

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

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


    }
}
