package com.example.recyclerviewsharedpref;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter_1 extends RecyclerView.Adapter<OrderAdapter_1.MyViewHolder> {

    List<String> OrderName;
    List<String> OrderDate;

    public OrderAdapter_1(List<String> orderName, List<String> orderDate) {
        OrderName = orderName;
        OrderDate = orderDate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ordercardview,viewGroup,false);
        return (new MyViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        viewHolder.OrderName.setText(OrderName.get(i));
        viewHolder.OrderDate.setText(OrderDate.get(i));
    }

    @Override
    public int getItemCount() {
        return OrderDate.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView OrderName,OrderDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            OrderDate= (TextView) itemView.findViewById(R.id.visit_date);
            OrderName= (TextView) itemView.findViewById(R.id.farmer_name);
        }
    }
}
