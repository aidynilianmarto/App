package com.example.pc.olx.Shop;

import com.example.pc.olx.Offer.Offer;

import java.util.ArrayList;

/**
 * Created by Kali on 17.9.2016 г..
 */
public class Shop {

    private ArrayList<Offer> allOffers;
    private static Shop ourInstance = new Shop();

    private Shop() {
        allOffers = new ArrayList<>();
    }


    public static Shop getInstance() {
        return ourInstance;
    }

    public void addOffer(Offer o){
        allOffers.add(o);
    }


}
