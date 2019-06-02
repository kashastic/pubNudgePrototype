package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedCropActity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_crop_actity);
        Intent intent=getIntent();
        crop crop=intent.getParcelableExtra("Crop Name");

        int cropimage = crop.getCropimage();
        String cropname = crop.getCropname();

        ImageView imageView = findViewById(R.id.selectedCropImage);
        imageView.setImageResource(cropimage);
        TextView textView1 = findViewById(R.id.selectedCropName);
        textView1.setText(cropname);
    }
}
