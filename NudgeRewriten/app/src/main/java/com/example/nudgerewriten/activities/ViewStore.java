package com.example.nudgerewriten.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.ProductAdapter;
import com.example.nudgerewriten.adapters.ProductViewAdapter;
import com.example.nudgerewriten.models.products;

import java.util.ArrayList;
import java.util.List;

public class ViewStore extends AppCompatActivity {

    public RecyclerView prodRcvId;
    public RecyclerView.LayoutManager layoutManager;
    List<products> Products = new ArrayList<>();
    private Toolbar toolbar;
    private ProductViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_store);
        for(int i=0;i<6; i++ ) {
            Products.add(new products("Product "+"i","Company "+ "i",(1+i)*100 ,R.drawable.fertilizer));
        }
        toolbar= findViewById(R.id.itempurchage);
        setSupportActionBar(toolbar);
        prodRcvId=findViewById(R.id.recyclerViewStore);
        layoutManager = new LinearLayoutManager(this);
        prodRcvId.setHasFixedSize(true);
        prodRcvId.setLayoutManager(layoutManager);
        adapter = new ProductViewAdapter(Products,ViewStore.this);
        prodRcvId.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.itemselect_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
