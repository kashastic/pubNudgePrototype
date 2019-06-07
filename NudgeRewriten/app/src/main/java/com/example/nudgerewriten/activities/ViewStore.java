package com.example.nudgerewriten.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nudgerewriten.R;
import com.example.nudgerewriten.adapters.ProductAdapter;
import com.example.nudgerewriten.adapters.ProductViewAdapter;
import com.example.nudgerewriten.models.products;

import java.util.ArrayList;
import java.util.List;

public class ViewStore extends AppCompatActivity implements View.OnLongClickListener {

    public boolean is_item_checked=false;
    TextView counterTextview;
    public RecyclerView prodRcvId;
    public RecyclerView.LayoutManager layoutManager;
    List<products> Products = new ArrayList<>();
    private Toolbar toolbar;
    private ProductViewAdapter adapter;
    ArrayList<products> selectionlist;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_store);
        toolbar= (Toolbar) findViewById(R.id.itempurcharge);
        setSupportActionBar(toolbar);
        counterTextview=(TextView) findViewById(R.id.counterItem);
        counterTextview.setVisibility(View.GONE);
        for(int i=0;i<6; i++ ) {
            Products.add(new products("Product "+i,"Company "+i,(1+i)*100 ,R.drawable.fertilizer));
        }
        selectionlist = new ArrayList<>();
        prodRcvId=findViewById(R.id.recyclerViewStore);
        layoutManager = new LinearLayoutManager(this);
        prodRcvId.setHasFixedSize(true);
        prodRcvId.setLayoutManager(layoutManager);
        adapter = new ProductViewAdapter(Products,this);
        prodRcvId.setAdapter(adapter);
    }



    @Override
    public boolean onLongClick(View v) {
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.itemselect_menu);
        counterTextview.setVisibility(View.VISIBLE);
        is_item_checked=true;
        adapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }
    public void prepareselection(View view,int pos){

        if(((CheckBox)view).isChecked()){
            selectionlist.add(Products.get(pos));
            count +=1;
            updateCounnter(count);
        }
        else {
            selectionlist.remove(Products.get(pos));
            count-=1;
            updateCounnter(count);
        }

    }
    public void updateCounnter(int count)
    {
        if(count == 0)
        {
            counterTextview.setText("0 item Selected");
        }
        else {
            counterTextview.setText(count+"item Selected");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item_delete)
        {
            clearAction();
            ProductViewAdapter productadapter= (ProductViewAdapter) adapter;
            productadapter.updateAdapter(selectionlist);

        }
        else if (item.getItemId()== android.R.id.home)
        {
            clearAction();
            adapter.notifyDataSetChanged();
        }
        return true;
    }

    public void clearAction(){
        is_item_checked= false;
        toolbar.getMenu().clear();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        counterTextview.setText(View.GONE);
        counterTextview.setText("0 item Selected");
    }
    @Override
    public void onBackPressed() {
        if (is_item_checked) {
            clearAction();
            adapter.notifyDataSetChanged();
        }
        else {
            super.onBackPressed();
        }
    }
}
