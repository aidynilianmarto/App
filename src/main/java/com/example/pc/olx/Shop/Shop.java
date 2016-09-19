package com.example.pc.olx.Shop;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.pc.olx.Offer.Offer;
import com.example.pc.olx.R;
import com.example.pc.olx.User.User;
import com.example.pc.olx.User.UserManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Kali on 17.9.2016 г..
 */
public class Shop {

    private ArrayList<Offer> offers;
    private static Shop ourInstance;

    private Shop(Activity activity) {

        this.offers = new ArrayList<>();

        Offer offer1 = new Offer("Ostrov", 231312.22, "Na mnogo izgodna cena, nqma zabelejki", "Kaspichan", R.drawable.island1, Offer.State.USED, "Overseas properties");
        Offer offer2 = new Offer("Komputer", 2321, "Za vsqkakvi geimki", "Varna", R.drawable.pc, Offer.State.NEW, "Computers");
        Offer offer3 = new Offer("Ostrov", 231312.22, "Na mnogo izgodna cena, nqma zabelejki", "Kaspichan", R.drawable.island1, Offer.State.USED, "Overseas properties");
        Offer offer4 = new Offer("Komputer", 2321, "Za vsqkakvi geimki", "Varna", R.drawable.pc, Offer.State.NEW, "Computers");
        Offer offer5 = new Offer("Ostrov", 231312.22, "Na mnogo izgodna cena, nqma zabelejkiNa mnogo izgodna cena, nqma zabelejki", "Kaspichan", R.drawable.island1, Offer.State.USED, "Overseas properties");
        Offer offer6 = new Offer("Komputer", 2321, "Za vsqkakvi geimki", "Varna", R.drawable.pc, Offer.State.NEW, "Computers");
        Offer offer7 = new Offer("Ostrov", 231312.22, "Na mnogo izgodna cena, nqma zabelejki", "Kaspichan", R.drawable.island1, Offer.State.USED, "Overseas properties");
        Offer offer8 = new Offer("Komputer", 2321, "Za vsqkakvi geimki", "Varna", R.drawable.pc, Offer.State.NEW, "Computers");

        offer1.addPhoto(R.drawable.randompic2);
        offer1.addPhoto(R.drawable.randompic3);
        offer1.addPhoto(R.drawable.randompic4);
        offer1.addPhoto(R.drawable.randompic5);
        offer1.addPhoto(R.drawable.randompic1);

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);
        offers.add(offer6);
        offers.add(offer7);
        offers.add(offer8);

        UserManager.getInstance(activity).userRegister(activity, "peshko", "Pesho Kasapina", "123456", "adfasdf@fsd.fsd", "Adsfsad", "423423423",null);
        offer1.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer2.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer3.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer4.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer5.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer6.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer7.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer8.setUser(UserManager.getInstance(activity).getUser("peshko"));


//        String json = activity.getSharedPreferences("OLX", Context.MODE_PRIVATE).getString("offerInfo", "No added offers");
//        Log.e("offers", json.toString());
//
//        try {
//
//            JSONArray array = new JSONArray(json);
//            Log.e("offer", "3");
//            for(int i = 0; i<array.length(); i++){
//                JSONObject jobj = array.getJSONObject(i);
//                Offer.State st = null;
//
//                Log.e("offer", "1");
//                if(jobj.getString("state").equals("USED")){
//                    st = Offer.State.USED;
//                }
//                else{
//                    st = Offer.State.NEW;
//                }
//
//                Log.e("offer", "2");
//                Offer offer = new Offer(jobj.getString("name"),
//                                        Double.parseDouble(jobj.getString("price")),
//                                        jobj.getString("description"),
//                                        jobj.getString("location"),
//                                        Integer.parseInt(jobj.getString("picture")),
//                                        st,
//                                        jobj.getString("category"));
//                Log.e("offer", offer.toString());
//                offers.add(offer);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        Log.e("size1", offers.size()+"");

    }


    public static Shop getInstance(Activity activity) {
        if(ourInstance == null){
            ourInstance = new Shop(activity);
        }

        return ourInstance;
    }

    public void addOffer(Activity activity, Offer o){

        o.addPhoto(o.getMainPhoto());
        offers.add(o);

//        SharedPreferences prefs = activity.getSharedPreferences("OLX", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        Log.e("size2", offers.size()+"");
//
//        JSONArray jarr = new JSONArray();
//
//        for(Offer offer : offers){
//            try {
//                JSONObject jobj = new JSONObject();
//                jobj.put("name", offer.getName());
//                jobj.put("price", offer.getPrice()+"");
//                jobj.put("description", offer.getDescription());
//                jobj.put("location", offer.getLocation());
//                jobj.put("picture", offer.getMainPhoto()+"");
//                jobj.put("state", offer.getState().toString());
//                jobj.put("category", offer.getCategory());
//                jarr.put(jobj);
//
//                if(jobj == null){
//                    continue;
//                }
//                Log.e("obj", jobj.toString());
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        Log.e("jarr", jarr.toString());
//        String jsonOffers = jarr.toString();
//        editor.putString("offerInfo", jsonOffers);
//        editor.commit();
    }

    public ArrayList<Offer> getALlOffers(){
        return offers;
    }

}
