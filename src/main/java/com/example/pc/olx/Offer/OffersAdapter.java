package com.example.pc.olx.Offer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pc.olx.R;
import com.example.pc.olx.User.User;

import java.util.List;

/**
 * Created by Kali on 13.9.2016 г..
 */
public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OfferViewHolder> {


    private List<Offer> offers;
    private Activity activity;
    private String user;

    public OffersAdapter(Activity activity, List<Offer> offers,String user){
        this.activity = activity;
        this.offers = offers;
        this.user = user;
    }

    class OfferViewHolder extends RecyclerView.ViewHolder{

        ImageView offerMainImage;
        TextView offerTitle;
        TextView offerPrice;
        TextView offerLocation;
        TextView offerDescrioption;
        LinearLayout rootLayout;

        public OfferViewHolder(View item) {
            super(item);

            offerMainImage = (ImageView) item.findViewById(R.id.offer_view_picture);
            offerTitle = (TextView) item.findViewById(R.id.name);
            offerPrice = (TextView) item.findViewById(R.id.amountTV);
            offerLocation = (TextView) item.findViewById(R.id.location);
            offerDescrioption = (TextView) item.findViewById(R.id.description);
        }
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.home_page_offer_layout, parent, false);
        item.findViewById(R.id.offer_root_layout).setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        OfferViewHolder vh = new OfferViewHolder(item);
        return vh;
    }

    @Override
    public void onBindViewHolder(OfferViewHolder holder, int position) {

        final Offer offer = offers.get(position);

        holder.offerMainImage.setImageResource(offer.getMainPhoto());
        holder.offerDescrioption.setText(offer.getDescription());
        holder.offerTitle.setText(offer.getName());
        holder.offerLocation.setText(offer.getLocation());
        holder.offerPrice.setText(offer.getPrice()+"");

        holder.offerMainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, OfferActivity.class);
                intent.putExtra("offer", offer);
                intent.putExtra("login",activity.getIntent().getStringExtra("login"));
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }
}
