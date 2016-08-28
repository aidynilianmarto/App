package com.example.pc.olx.Offer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.olx.R;

import java.util.ArrayList;

/**
 * Created by pc on 28.8.2016 г..
 */
public class OfferAdapter extends ArrayAdapter<Offer> {

    OfferAdapter(Context context, ArrayList<Offer> offers){
        super(context, 0, offers);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Offer offer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.home_page_offer_layout, parent, false);
        }

        ImageView iv = (ImageView) convertView.findViewById(R.id.offer_image_view);
        TextView tv = (TextView) convertView.findViewById(R.id.text_under_pic);

        iv.setImageDrawable(offer.getMainPhoto());
        tv.setText(offer.getName());

        return convertView;
    }
}
