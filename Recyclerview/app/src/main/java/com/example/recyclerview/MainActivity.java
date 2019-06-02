package com.example.recyclerview;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.SearchView;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener, RecyclerAdapter.onCropListener {

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.component, R.drawable.component1, R.drawable.component2,
            R.drawable.component3, R.drawable.component4, R.drawable.component5};
    private String[] croplist = {"Potato", "Chilly", "Tomato", "Carrot", "Onion", "Garlic"};
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private Toolbar toolbar;
    private ArrayList<crop> cropsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        int count = 0;
        for (String name : croplist) {
            cropsList.add(new crop(name, images[count]));
            count++;
        }
        adapter = new RecyclerAdapter(cropsList,this);
        recyclerView.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        //MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<crop> newList = new ArrayList<>();
        for (crop crop : cropsList) {
            String cropname = crop.getCropname().toLowerCase();
            if (cropname.contains(newText)) {
                newList.add(crop);
            }
        }
        adapter.searchFilter(newList);
        return true;
    }

    @Override
    public void onCropClick(int position) {

        cropsList.get(position);
        Intent intent = new Intent(this,SelectedCropActity.class);
        intent.putExtra("Crop Name", cropsList.get(position));
        startActivity(intent);

    }
}