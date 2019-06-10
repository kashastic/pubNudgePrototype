package com.example.recyclerviewsharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


public class orderdetails extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SharedPreferences preferences;
    String text1,text2;
    ArrayList<String> orderNAme,Orderdate;
    OrderAdapter_1 adapter;

    @Override
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderddetails);

        preferences = getSharedPreferences(getResources().getString(R.string.SaveContext),MODE_PRIVATE);
        try {
            orderNAme = (ArrayList<String>) ObjectSerializer.deserialize(preferences.getString("OrderName",ObjectSerializer.serialize(new ArrayList<String>())));
            Orderdate= (ArrayList<String>) ObjectSerializer.deserialize(preferences.getString("OrderDate",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.Recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter= new OrderAdapter_1(orderNAme,Orderdate);
        recyclerView.setAdapter(adapter);

    }
}
