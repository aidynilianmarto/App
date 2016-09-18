package com.example.pc.olx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.pc.olx.Offer.OffersAdapter;
import com.example.pc.olx.User.Message;
import com.example.pc.olx.User.User;
import com.example.pc.olx.User.UserManager;

public class MessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String userName = getIntent().getStringExtra("login");

        User u = UserManager.getInstance(MessageActivity.this).getUser(userName);

        Message message1 = new Message("Message1", "Description1", u);
        Message message2 = new Message("Message2", "Description2", u);
        Message message3 = new Message("Message3", "Description3", u);
        Message message4 = new Message("Message4", "Description4", u);

        UserManager.getInstance(MessageActivity.this).sendMessage("aidyncho", "marrto", message1);
        UserManager.getInstance(MessageActivity.this).sendMessage("aidyncho", "marrto", message2);
        UserManager.getInstance(MessageActivity.this).sendMessage("aidyncho", "marrto", message3);
        UserManager.getInstance(MessageActivity.this).sendMessage("aidyncho", "marrto", message4);

        MessageAdapter adapter = new MessageAdapter(MessageActivity.this, u.getAllMessages());
        Log.e("Ada", adapter.getItemCount()+"");
        RecyclerView lv = (RecyclerView) findViewById(R.id.message);
        lv.setLayoutManager(new LinearLayoutManager(MessageActivity.this, LinearLayoutManager.VERTICAL, false));
        lv.setAdapter(adapter);

    }
}
