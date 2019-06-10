package com.example.recyclerviewsharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

public class orderpage  extends AppCompatActivity {

    EditText text1,text2;
    Button button,button1;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    List<String> orderString;
    List<String> orderDate;
    Set<String> set,set1;
    @Override
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderpage);
        text1= findViewById(R.id.editText);
        text2= findViewById(R.id.editText2);
        button1 = findViewById(R.id.button4);
        button = findViewById(R.id.button3);
        orderDate = new ArrayList<>();
        orderString = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = text1.getText().toString();
                String s1= text2.getText().toString();
                orderDate.add(s1);
                orderString.add(s);
                Toast.makeText(orderpage.this, " ADDED !!!", Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences(getResources().getString(R.string.SaveContext),MODE_PRIVATE);
                editor = preferences.edit();
                try {

                    editor.putString("OrderDate",ObjectSerializer.serialize((Serializable) orderDate)).apply();
                    editor.putString("OrderName",ObjectSerializer.serialize((Serializable) orderString)).apply();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                editor.commit();
                Toast.makeText(orderpage.this, "You have ordered.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
