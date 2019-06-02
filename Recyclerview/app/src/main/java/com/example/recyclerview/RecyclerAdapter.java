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

public class RecyclerAdapter extends Adapter <RecyclerAdapter.ImageViewHolder>{

    private ArrayList<crop> cropList;
    private onCropListener onCropListener;

    public RecyclerAdapter( ArrayList<crop> crops, onCropListener onCropListener){

        this.cropList=crops;
        this.onCropListener=onCropListener;
    }
    @Nullable
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.croplist,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,onCropListener);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {

        viewHolder.crop.setImageResource(cropList.get(i).getCropimage());
        viewHolder.croptitle.setText(cropList.get(i).getCropname());
    }

    @Override
    public int getItemCount() {
        return cropList.size();
    }

    public static class  ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView crop;
        TextView croptitle;
        onCropListener onCropListener;
        public ImageViewHolder(@NonNull View itemView , onCropListener onCropListener) {
            super(itemView);
            crop=  (ImageView) itemView.findViewById(R.id.crop);
            croptitle=(TextView) itemView.findViewById(R.id.croptitle);
            this.onCropListener= onCropListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCropListener.onCropClick(getAdapterPosition());
        }
    }

    public void searchFilter(ArrayList<crop> newList)
    {
        cropList = new ArrayList<>();
        notifyDataSetChanged();
    }

    public interface onCropListener{

        void onCropClick(int position);
    }




}
