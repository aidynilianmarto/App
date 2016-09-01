package com.example.pc.olx.User;

import java.io.Serializable;

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

    public User(String username, String name, String password, String email, String address, String phone) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
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
}

