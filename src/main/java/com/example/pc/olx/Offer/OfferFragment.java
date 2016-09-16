package com.example.pc.olx.Offer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.olx.R;
import com.example.pc.olx.User.User;

import java.util.ArrayList;
import android.support.v4.app.Fragment;

/**
 * Created by Aydin on 14.9.2016 г..
 */
public class OfferFragment extends android.support.v4.app.Fragment {
    private Communicator activity;


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
        User pesho = new User("Petyr Stoyanov", "liliputq99", "shishi44 ", "palavata.palka@abv.bg", "Kaspichansko usoe", "0889456678");

        Offer offer1 = new Offer("Prodavam ostrov  ", 2000000, "V mnogo dobro sastoqnie, chudesen izgled kam oekana, ima tuk tam nqkoi kamak da bade izvaden.", "Chillie", R.drawable.island1, Offer.State.USED);
        Offer offer2 = new Offer("Prodavam computer", 445, "V mnogo dobro sastoqnie, stava za vsqkakvi igri, HDD:1TB, VC:Vapor-X R, CPU: i7-4790K", "Varna", R.drawable.fblogin, Offer.State.NEW);

        offer1.setUser(pesho);
        offer2.setUser(pesho);

        ArrayList<Offer> offers = new ArrayList<>();

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);

        OffersAdapter adapter = new OffersAdapter(getActivity(), offers);
        RecyclerView lv = (RecyclerView)   root.findViewById(R.id.offer);
        lv.setAdapter(adapter);
        lv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));


        return root;
    }

}

