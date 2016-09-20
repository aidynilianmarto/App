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

        Offer offer1 = new Offer("iPhone 6", 222.65, "В много добро състояние, телефона е ползван само 4-5 месеца.", "Каспичан", R.drawable.ip1, Offer.State.USED, "Phones");
        Offer offer2 = new Offer("Smart TV", 1239, "Телевизора не е пускан, стои си още в кашона. Цената е крайна.", "Каспичан", R.drawable.stv1, Offer.State.NEW, "Computers");
        Offer offer3 = new Offer("Обувки", 70, "Маратонките са чисто нови, червен цвят, номер 39. Цената може да се коментира", "Каспичан", R.drawable.sh1, Offer.State.NEW, "Shoes");
        Offer offer4 = new Offer("Бебешки дрешки", 1, "Всякакъв размер бебешки дрешки, за момиченца и момченца. Чисто нови, за повече инфо пишете съобщение", "Каспичан", R.drawable.cl1, Offer.State.NEW, "Baby and children clothes");
        Offer offer5 = new Offer("Yamaha YZF R1", 4000, "Мотора е в добро състояние, падано е само 2-3 пъти с него. Има леки забележки по боята", "Каспичан", R.drawable.bike, Offer.State.USED, "Bikes and ATB");
        Offer offer6 = new Offer("Игри за PS3", 1, "В перфектно състояние Mafia 2 е колекционерско издание пишете за цени.", "Каспичан", R.drawable.ps1, Offer.State.USED, "Games");

        offer1.addPhoto(R.drawable.ip2);
        offer1.addPhoto(R.drawable.ip3);

        offer2.addPhoto(R.drawable.stv2);

        offer3.addPhoto(R.drawable.sh2);
        offer3.addPhoto(R.drawable.sh3);

        offer4.addPhoto(R.drawable.cl2);
        offer4.addPhoto(R.drawable.cl3);
        offer4.addPhoto(R.drawable.cl4);
        offer4.addPhoto(R.drawable.cl5);

        offer6.addPhoto(R.drawable.cl5);




        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);
        offers.add(offer5);
        offers.add(offer6);

        UserManager.getInstance(activity).userRegister(activity, "peshko", "Pesho Kasapina", "123456", "pesh@ko.kasi", "Каспичан, ул. Софийска", "0878345512",null);
        offer1.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer2.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer3.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer4.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer5.setUser(UserManager.getInstance(activity).getUser("peshko"));
        offer6.setUser(UserManager.getInstance(activity).getUser("peshko"));


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
