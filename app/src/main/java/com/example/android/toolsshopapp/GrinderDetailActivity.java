package com.example.android.toolsshopapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GrinderDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewDrill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grinder_detail);

        //скрываем actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewDrill = findViewById(R.id.imageViewGrinder);

        Intent intent =  getIntent();

        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);

            textViewTitle.setText(title);
            textViewInfo.setText(info);
            //чтобы установить изображение нужно установить setImageResource
            imageViewDrill.setImageResource(resId);
        }else {
            Intent backPage1 = new Intent(this, GrinderCategoryActivity.class);
            startActivity(backPage1);
        }
    }
}
