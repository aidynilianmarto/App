package com.example.pc.olx.User;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Aydin on 29.8.2016 г..
 */
public class UserManager {
    private static UserManager ourInstance;
    private HashMap<String, User> userInfo;

    public static UserManager getInstance(Activity activity) {
        if(ourInstance == null){
            ourInstance = new UserManager(activity);
        }
        return ourInstance;
    }


    private UserManager(Activity activity) {

        userInfo = new HashMap<>();
        String json = activity.getSharedPreferences("OLX", Context.MODE_PRIVATE).getString("userInfo", "no users");
        Log.e("LOADED USERS", json);

        try {
            JSONArray arr = new JSONArray(json);

            for(int i = 0; i < arr.length(); i++){
                JSONObject obj = arr.getJSONObject(i);
                ArrayList<Message> messages = new ArrayList<Message>();
                for(int j = 0; j < obj.getJSONArray("messages").length() ; j++){
                   JSONObject msg = obj.getJSONArray("messages").getJSONObject(j);
                    Message m = new Message(msg.getString("title"),msg.getString("desc") , (User)msg.get("user"));
                    messages.add(m);
                }
                User user = new User(obj.getString("username"),
                        obj.getString("name"),
                        obj.getString("password"),
                        obj.getString("email"),
                        obj.getString("address"),
                        obj.getString("phone"),
                        messages );
                userInfo.put(user.getUsername(), user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public boolean existsUser(String username) {
        return userInfo.containsKey(username);
    }

    public void userRegister(Activity activity, String username,String name, String pass1, String email, String addr, String phone,ArrayList<Message> messages ) {
        User user = new User(username, name,pass1, email, addr, phone,messages);
        userInfo.put(username, user);
        SharedPreferences prefs = activity.getSharedPreferences("OLX",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "userInfo";
        String value = "...";//JSON format containing all users from the collection
        JSONArray jsonUsers = new JSONArray();
        try {
            for (User u : userInfo.values()) {
                JSONObject jobj = new JSONObject();
                JSONArray jsonarr = new JSONArray();
                for(int i = 0;i<u.getAllMessages().size() ; i++){
                    JSONObject msgobj = new JSONObject();
                    Message m = u.getAllMessages().get(i);
                    msgobj.put("title", m.getTitle());
                    msgobj.put("desc" , m.getDesc());
                    msgobj.put("user", m.getUser());
                    jsonarr.put(jobj);
                }
                jobj.put("username", u.getUsername());
                jobj.put("name",u.getName());
                jobj.put("password", u.getPassword());
                jobj.put("email", u.getEmail());
                jobj.put("address", u.getAddress());
                jobj.put("phone", u.getPhone());
                jobj.put("messages" , jsonarr );
                jsonUsers.put(jobj);
            }
        }
        catch(JSONException e){
            Log.e("JSON", e.getMessage());
        }
        value = jsonUsers.toString();
        Log.e("JSON", value);
        editor.putString(key, value);
        editor.commit();
    }

    public boolean isLogin(String username, String password) {
        if (!existsUser(username)){
            Log.e("F", "user does not exist in map");
            return false;
        }
        if(!(userInfo.get(username).getPassword().equals(password))){
            Log.e("F","user pass is wrong");
            return false;
        }
        return true;
    }

    public final static boolean isValidEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    public void sendMessage(String senderName,String receiverName,Message m){
        if(senderName!=null && !(senderName.isEmpty()) && receiverName!=null && !(receiverName.isEmpty())  ){
            userInfo.get(senderName).getSendedMessages().add(m);
            userInfo.get(receiverName).getReceivedMessages().add(m);
            userInfo.get(senderName).getAllMessages().add(m);
            userInfo.get(receiverName).getAllMessages().add(m);
            return;
        }
    }

    public void changePassword(Activity activity,String username,String password){
        User u = getUser(username);
        userInfo.remove(username);
        userRegister(activity,u.getUsername(),u.getName(),password,u.getEmail(),u.getAddress(),u.getPhone(),u.getAllMessages());

    }
    public void changeEmail(Activity activity,String username,String email){
        User u = getUser(username);
        userInfo.remove(username);
        userRegister(activity,u.getUsername(),u.getName(),u.getPassword(),email,u.getAddress(),u.getPhone(),u.getAllMessages());
    }
    public void changeAddress(Activity activity,String username,String address){
        User u = getUser(username);
        userInfo.remove(username);
        userRegister(activity,u.getUsername(),u.getName(),u.getPassword(),u.getEmail(),address,u.getPhone(),u.getAllMessages());
    }

    public void changePhone(Activity activity,String username,String phone){
        User u = getUser(username);
        userInfo.remove(username);
        userRegister(activity,u.getUsername(),u.getName(),u.getPassword(),u.getEmail(),u.getAddress(),phone,u.getAllMessages());
    }

    public static boolean validate(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
    public User getUser(String sender) {
        return userInfo.get(sender);
    }
}
