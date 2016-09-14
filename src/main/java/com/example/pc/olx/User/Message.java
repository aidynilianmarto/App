package com.example.pc.olx.User;

/**
 * Created by iliqn on 14.9.2016 г..
 */
public class Message {
    private String title;
    private String desc;
    private boolean isReaded;
    private User user;

    public Message(String title, String desc,User u) {
        if(title!=null && !(title.isEmpty())) {
            this.title = title;
        }
        this.isReaded = false;
        if(desc!=null && !(desc.isEmpty())){
            this.desc = desc;
        }
        if(u!=null){
            this.user = u;
        }
    }


    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public User getUser() {
        return user;
    }
}
