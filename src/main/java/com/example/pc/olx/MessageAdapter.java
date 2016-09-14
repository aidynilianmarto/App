package com.example.pc.olx;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.olx.User.Message;

import java.util.List;

/**
 * Created by iliqn on 14.9.2016 г..
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messages;
    private LayoutInflater inflater;

    public MessageAdapter(List<Message> messages,LayoutInflater inflater) {
        this.messages = messages;
        this.inflater = inflater;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.message_list,parent,false);
        MessageViewHolder viewHolder = new MessageViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message m = messages.get(position);
        holder.titleOfMessageTV.setText(m.getTitle());
        holder.userNameTV.setText(m.getUser().getName());
    }

    @Override
    public int getItemCount() {
       return messages.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView titleOfMessageTV;
        private TextView userNameTV;
        public MessageViewHolder(View itemView) {
            super(itemView);
            titleOfMessageTV = (TextView) itemView.findViewById(R.id.titleOfMessageTV);
            userNameTV = (TextView) itemView.findViewById(R.id.userNameTV);
        }
    }
}

