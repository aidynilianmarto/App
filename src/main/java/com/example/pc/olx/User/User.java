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

    public User(String name, String username, String password, String email, String address, String phone) {
        this.name = name;
        this.username = username;
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

