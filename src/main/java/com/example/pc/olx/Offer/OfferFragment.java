package com.example.pc.olx.Offer;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.olx.R;
import com.example.pc.olx.Shop.Shop;
import com.example.pc.olx.User.User;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;

/**
 * Created by Aydin on 14.9.2016 г..
 */
public class OfferFragment extends android.support.v4.app.Fragment {
    private Communicator activity;
    private String user;


    public interface Communicator{
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity=(Communicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.offers, container, false);

        ArrayList<Offer> offers = Shop.getInstance(getActivity()).getALlOffers();

        OffersAdapter adapter = new OffersAdapter(getActivity(), offers,user);
        RecyclerView lv = (RecyclerView)   root.findViewById(R.id.offer);
        lv.setAdapter(adapter);
        lv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));


        return root;
    }
    
}

