package com.example.pc.olx.User;

/**
 * Created by Aydin on 29.8.2016 г..
 */
public class User {
    private String username;
    private String name;
    private String password;
    private String email;

    User(String username,String name,String password,String email){
        this.username = username;
        this.name=name;
        this.password=password;
        this.email=email;
    }

    public String getPassword() {
        return password;
    }
}
