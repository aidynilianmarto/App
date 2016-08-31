package com.example.pc.olx.Offer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.olx.Offer.Offer;
import com.example.pc.olx.R;

import java.util.ArrayList;

/**
 * Created by pc on 31.8.2016 г..
 */
public class OfferAdapter extends ArrayAdapter<Offer> {

    public OfferAdapter(Context context, ArrayList<Offer> offers){
        super(context, 0, offers);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Offer offer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.home_page_offer_layout, parent, false);
        }

        ImageView iv = (ImageView) convertView.findViewById(R.id.offer_view_picture);
        TextView tv = (TextView) convertView.findViewById(R.id.name);
        TextView priceTV = (TextView) convertView.findViewById(R.id.priceTV);
        TextView priceAmt = (TextView) convertView.findViewById(R.id.amountTV);
        TextView locationTV = (TextView) convertView.findViewById(R.id.locationTV);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        TextView description = (TextView) convertView.findViewById(R.id.description);



        iv.setImageResource(offer.getMainPhoto());
        tv.setText(offer.getName());
        priceAmt.setText(Double.toString(offer.getPrice()));
        location.setText(offer.getLocation());
        description.setText(offer.getDescription());

        return convertView;
    }
}
