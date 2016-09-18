package com.example.pc.olx;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.olx.User.Message;

import java.util.List;

/**
 * Created by iliqn on 17.9.2016 г..
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messageList;
    private Activity activity;
    private String username;

    public MessageAdapter(Activity activity, List<Message> message,String userName){
        this.activity = activity;
        this.messageList = message;
        this.username = userName;
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView titleOfMessageTV;
        TextView userNameTV;
        TextView messageTypeTV;
        LinearLayout layout;
        public MessageViewHolder(View itemView) {
            super(itemView);
            titleOfMessageTV = (TextView) itemView.findViewById(R.id.titleOfMessageTV);
            userNameTV = (TextView) itemView.findViewById(R.id.userNameTV);
            layout = (LinearLayout) itemView.findViewById(R.id.messageList);
            messageTypeTV = (TextView) itemView.findViewById(R.id.messageTypeTV);
        }
    }

    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.messege_layout, parent, false);
        MessageViewHolder vh = new MessageViewHolder(item);
        item.findViewById(R.id.messageList).setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return vh;
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageViewHolder holder, int position) {
        Log.e("msg" , "position "+position);
        final Message message = messageList.get(position);
        holder.userNameTV.setText(message.getUser().getName());
        holder.titleOfMessageTV.setText(message.getTitle());
        if(message.getUser().getUsername().equals(username)){
            holder.messageTypeTV.setText("Sended Message");
        }else{
            holder.messageTypeTV.setText("Received Message");
        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,PreviousMessageActivity.class);
                intent.putExtra("title" , message.getTitle());
                intent.putExtra("userName", message.getUser().getName());
                intent.putExtra("desc", message.getDesc());
                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.e("msg" , "item count"+messageList.size());
        return messageList.size();
    }

}
