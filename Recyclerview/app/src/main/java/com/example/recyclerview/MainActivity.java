package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private int[] images =
            {R.drawable.component,R.drawable.component1,R.drawable.component2,
             R.drawable.component3,R.drawable.component4,R.drawable.component5 };
    private List<String> croplist;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdpater adpater;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        croplist = Arrays.asList("Potato","Chilly","Tomato","Carrot","Onion","Garlic");
        layoutManager= new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adpater = new RecyclerAdpater(images,croplist);
        recyclerView.setAdapter(adpater);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextFocusChangeListener((View.OnFocusChangeListener) this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String userinput = newText.toLowerCase();
        List<String> newlist = new ArrayList<>();

        for( String name : croplist) {
            if(name.toLowerCase().contains(userinput))
            {
                newlist.add(name);
            }
        }
        adpater.update(newlist);
        return true;
    }
}
