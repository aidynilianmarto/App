package com.example.pc.olx;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.olx.User.Message;

import java.util.List;

public class MessageFragment extends Fragment {
    List<Message> messages;
    Communicator activity;
    RecyclerView recyclerView;
    Activity activity1;

    public MessageFragment(Activity activity,List<Message> messages) {
        super();
        this.messages = messages;
        this.activity1 = activity;


    }

    interface Communicator{
        void notifyFragmentAction();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Communicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_message, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.fragmentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity1));
        recyclerView.setAdapter(new MessageAdapter(messages,getActivity().getLayoutInflater()));
        return root;
    }

}
