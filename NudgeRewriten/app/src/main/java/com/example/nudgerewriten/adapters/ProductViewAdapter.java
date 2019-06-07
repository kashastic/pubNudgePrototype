package com.example.nudgerewriten.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.activities.ViewStore;
import com.example.nudgerewriten.models.products;

import java.util.ArrayList;
import java.util.List;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder> {

    public List<products> Products;
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
        if(!viewStore.is_item_checked)
        {
            viewHolder.checkBox.setVisibility(View.GONE);
        }
        else {
            viewHolder.checkBox.setVisibility(View.VISIBLE);
            viewHolder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView itemimage;
        TextView Productname,Productcompany,Price;
        CheckBox checkBox;
        ViewStore viewStore;
        CardView cardView;
        public ProductViewHolder(@NonNull View itemView, ViewStore viewStore) {
            super(itemView);
            itemimage=(ImageView) itemView.findViewById(R.id.viewstoreimage);
            Productname=(TextView) itemView.findViewById(R.id.viewproduct);
            Productcompany =(TextView) itemView.findViewById(R.id.viewproductcompany);
            Price=(TextView) itemView.findViewById(R.id.priceset);
            checkBox=(CheckBox) itemView.findViewById(R.id.checkeditems);
            cardView = (CardView) itemView.findViewById(R.id.eachproduct);
            cardView.setOnLongClickListener(viewStore);
            this.viewStore = viewStore;
            checkBox.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            viewStore.prepareselection(v,getAdapterPosition());
        }

    }
    public void updateAdapter(ArrayList<products> list)
    {
        for (products products: list)
        {
            Products.remove(products);
        }
        notifyDataSetChanged();
    }
}
