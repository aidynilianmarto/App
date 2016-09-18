package com.example.pc.olx.User;

import com.example.pc.olx.Offer.Offer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Aydin on 29.8.2016 г..
 */
public class User implements Serializable{
    private String username;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private ArrayList<Offer> offers;
    private ArrayList<Message> receivedMessages;
    private ArrayList<Message> sendedMessages;
    private ArrayList<Message> allMessages;

    public User(String username, String name, String password, String email, String address, String phone) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        receivedMessages = new ArrayList<>();
        sendedMessages = new ArrayList<>();
        allMessages = new ArrayList<>();
        offers = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public ArrayList<Message> getSendedMessages() {
        return sendedMessages;
    }

    public ArrayList<Message> getAllMessages() {
        return allMessages;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

