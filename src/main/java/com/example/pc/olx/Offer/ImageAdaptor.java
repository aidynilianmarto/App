package com.example.pc.olx.Offer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pc.olx.R;

import java.util.List;

/**
 * Created by Kali on 20.9.2016 г..
 */
public class ImageAdaptor extends RecyclerView.Adapter<ImageAdaptor.ImageVH> {

    private List<Integer> pics;
    private Activity activity;

    ImageAdaptor(Activity activity, List<Integer> pics){
        this.activity = activity;
        this.pics = pics;
    }

    @Override
    public ImageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.image_layout, parent, false);
        item.findViewById(R.id.images_layout).setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ImageVH vh = new ImageVH(item);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImageVH holder, int position) {

        int pic = pics.get(position);
        holder.imageIV.setImageResource(pic);

    }

    @Override
    public int getItemCount() {
        Log.e("size", pics.size()+"");
        return pics.size();
    }

    class ImageVH extends RecyclerView.ViewHolder{

        ImageView imageIV;


        public ImageVH(View itemView) {
            super(itemView);
            imageIV = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
