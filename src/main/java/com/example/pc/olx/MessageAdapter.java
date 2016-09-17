package com.example.pc.olx;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.pc.olx.User.Message;

import java.util.List;

/**
 * Created by iliqn on 17.9.2016 г..
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messageList;
    private Activity activity;

    public MessageAdapter(Activity activity, List<Message> message){
        this.activity = activity;
        this.messageList = message;
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView titleOfMessageTV;
        TextView userNameTV;
        public MessageViewHolder(View itemView) {
            super(itemView);
            titleOfMessageTV = (TextView) itemView.findViewById(R.id.titleOfMessageTV);
            userNameTV = (TextView) itemView.findViewById(R.id.userNameTV);
        }
    }

    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_message, parent, false);
        MessageViewHolder vh = new MessageViewHolder(item);
        return vh;
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.userNameTV.setText(message.getUser().getName());
        holder.titleOfMessageTV.setText(message.getTitle());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

}
