package com.example.pc.olx.Offer;

import android.graphics.drawable.Drawable;

import com.example.pc.olx.Shop.Shop;
import com.example.pc.olx.User.User;

import java.util.ArrayList;

/**
 * Created by pc on 27.8.2016 г..
 */
public class Offer{
        private String name;
        private double price;
//      private LocalDateTime deadLine;
        private User user;
        private String date;
        private String description;
        private String location;
        private Category category;
        private ArrayList<Drawable> pictures = new ArrayList<>();
        private Drawable mainPhoto;

        public Offer(String name, double price,String description,String location) {
            if(name!=null && !(name.isEmpty())){
                this.name = name;
            }
            if(price>0){
                this.price = price;
            }
            if(description!=null && !(description.isEmpty())){
                this.description = description;
            }
//            this.deadLine = LocalDateTime.now().plusMonths(1);
            this.location = location;
            Shop.allOffers.add(this);

        }

        public void setUser(User u){
            this.user = u;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public User getUser() {
            return user;
        }

        public String getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        public String getLocation() {
            return location;
        }

        public Category getCategory() {
            return category;
        }

        public void setName(String newName) {
            this.name = newName;

        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Drawable getMainPhoto() {
            return mainPhoto;
        }

    //        public String getDeadLine() {
//            return "Deadline: " + deadLine.getDayOfMonth() + "-" + deadLine.getMonthValue()+ "-" + deadLine.getYear();
//        }
    }

