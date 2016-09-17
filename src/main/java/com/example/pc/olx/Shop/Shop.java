package com.example.pc.olx.Shop;

import com.example.pc.olx.Offer.Offer;
import com.example.pc.olx.R;
import com.example.pc.olx.User.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kali on 17.9.2016 г..
 */
public class Shop {

    private ArrayList<Offer> offers;
    private HashMap<String, User> users;
    private static Shop ourInstance = new Shop();

    private Shop() {

        this.offers = new ArrayList<>();

//        Offer offer1 = new Offer("Prodavam ostrov  ", 2000000, "V mnogo dobro sastoqnie, chudesen izgled kam oekana, ima tuk tam nqkoi kamak da bade izvaden.", "Chillie", R.drawable.island1, Offer.State.USED, "Roommates");
//        Offer offer2 = new Offer("Prodavam computer", 445, "V mnogo dobro sastoqnie, stava za vsqkakvi igri, HDD:1TB, VC:Vapor-X R, CPU: i7-4790K", "Varna", R.drawable.fblogin, Offer.State.NEW, "Roommates");




    }


    public static Shop getInstance() {
        return ourInstance;
    }

    public void addOffer(Offer o){
        offers.add(o);
    }

    public ArrayList<Offer> getALlOffers(){
        return offers;
    }

    private void staticOffers(){
        User pesho = new User("Petyr Stoyanov", "liliputq99", "shishi44 ", "palavata.palka@abv.bg", "Kaspichansko usoe", "0889456678");

        Offer offer1 = new Offer("Prodavam ostrov  ", 2000000, "V mnogo dobro sastoqnie, chudesen izgled kam oekana, ima tuk tam nqkoi kamak da bade izvaden.", "Chillie", R.drawable.island1, Offer.State.USED, "Roommates");
        Offer offer2 = new Offer("Prodavam computer", 445, "V mnogo dobro sastoqnie, stava za vsqkakvi igri, HDD:1TB, VC:Vapor-X R, CPU: i7-4790K", "Varna", R.drawable.fblogin, Offer.State.NEW, "Roommates");

        offer1.setUser(pesho);
        offer2.setUser(pesho);

    }

}
