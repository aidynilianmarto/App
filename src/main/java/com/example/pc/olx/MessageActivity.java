package com.example.pc.olx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pc.olx.User.User;
import com.example.pc.olx.User.UserManager;

public class MessageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        String userName = getIntent().getStringExtra("login");
        User u = UserManager.getInstance(MessageActivity.this).getUser(userName);

        MessageAdapter adapter = new MessageAdapter(MessageActivity.this, u.getAllMessages(),u.getUsername());
        Log.e("Ada", adapter.getItemCount()+"");
        RecyclerView lv = (RecyclerView) findViewById(R.id.message);
        lv.setLayoutManager(new LinearLayoutManager(MessageActivity.this, LinearLayoutManager.VERTICAL, false));
        lv.setAdapter(adapter);

    }
}
