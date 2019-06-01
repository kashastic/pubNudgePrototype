package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerAdpater extends Adapter <RecyclerAdpater.ImageViewHolder>{

    private int[] images;
    private List<String> cropfilter;

    public RecyclerAdpater(int[] images, List<String> croplist){
        this.images= images;
        this.cropfilter= croplist;

    }
    @Nullable
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.croplist,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {

        int image_id = images[i];
        viewHolder.crop.setImageResource(image_id);
        viewHolder.croptitle.setText(cropfilter.get(i));

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class  ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView crop;
        TextView croptitle;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            crop=  itemView.findViewById(R.id.crop);
            croptitle=itemView.findViewById(R.id.croptitle);
        }
    }
    public void update (List<String> newlist)
    {
        cropfilter = new ArrayList<>();
        cropfilter.addAll(newlist);
        notifyDataSetChanged();
    }
}
