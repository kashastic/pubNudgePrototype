package com.example.nudgerewriten.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.activities.MainActivity;
import com.example.nudgerewriten.activities.ViewStore;
import com.example.nudgerewriten.models.products;

import java.util.List;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder> {

    private List<products> Products;
    ViewStore viewStore;
    Context context;

    public ProductViewAdapter(List<products> products, Context context) {
        this.Products = products;
        this.context = context;
        viewStore = (ViewStore) context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_view_store_list,viewGroup,false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view,viewStore);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder viewHolder, int i) {
        viewHolder.itemimage.setImageResource(Products.get(i).getProductimage());
        viewHolder.Price.setText(Integer.toString(Products.get(i).getPrice()));
        viewHolder.Productname.setText(Products.get(i).getProductname());
        viewHolder.Productcompany.setText(Products.get(i).getProductComany());
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {
        ImageView itemimage;
        TextView Productname,Productcompany,Price;
        CheckBox checkBox;
        ViewStore viewStore;
        public ProductViewHolder(@NonNull View itemView, ViewStore viewStore) {
            super(itemView);
            itemimage=(ImageView) itemView.findViewById(R.id.viewstoreimage);
            Productname=(TextView) itemView.findViewById(R.id.viewproduct);
            Productcompany =(TextView) itemView.findViewById(R.id.viewproductcompany);
            Price=(TextView) itemView.findViewById(R.id.priceset);
            this.viewStore = viewStore;
        }
    }
}
