package com.example.pc.olx.Shop;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.pc.olx.Offer.Offer;
import com.example.pc.olx.R;
import com.example.pc.olx.User.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kali on 17.9.2016 г..
 */
public class Shop {

    private ArrayList<Offer> offers;
    private static Shop ourInstance;

    private Shop(Activity activity) {

        this.offers = new ArrayList<>();

        String json = activity.getSharedPreferences("OLX", Context.MODE_PRIVATE).getString("offerInfo", "No added offers");
        Log.e("offers", json.toString());

        try {
            JSONArray array = new JSONArray(json);

            for(int i = 0; i<array.length(); i++){
                JSONObject jobj = array.getJSONObject(i);
                Offer.State st = null;
                if(jobj.getString("state").equals("USED")){
                    st = Offer.State.USED;
                }
                else{
                    st = Offer.State.NEW;
                }
                Offer offer = new Offer(jobj.getString("name"),
                                        Double.parseDouble(jobj.getString("price")),
                                        jobj.getString("description"),
                                        jobj.getString("location"),
                                        Integer.parseInt(jobj.getString("picture")),
                                        st,
                                        jobj.getString("category"));
                offers.add(offer);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static Shop getInstance(Activity activity) {
        if(ourInstance == null){
            ourInstance = new Shop(activity);
        }

        return ourInstance;
    }

    public void addOffer(Activity activity, Offer o){

        offers.add(o);

        SharedPreferences prefs = activity.getSharedPreferences("OLX", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        JSONArray jarr = new JSONArray(offers);

        for(Offer offer : offers){
            try {
                JSONObject jobj = new JSONObject();
                jobj.put("name", offer.getName());
                jobj.put("price", offer.getPrice()+"");
                jobj.put("description", offer.getDescription());
                jobj.put("location", offer.getLocation());
                jobj.put("picture", offer.getMainPhoto()+"");
                jobj.put("state", offer.getState().toString());
                jobj.put("category", offer.getCategory());
                jarr.put(jobj);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String jsonOffers = jarr.toString();
        editor.putString("offerInfo", jsonOffers);
        editor.commit();
    }

    public ArrayList<Offer> getALlOffers(){
        return offers;
    }

}
