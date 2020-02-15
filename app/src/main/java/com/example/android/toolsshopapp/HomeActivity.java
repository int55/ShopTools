package com.example.android.toolsshopapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //скрываем actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        listView = findViewById(R.id.listViewTools);

        //добавляем слушатель событий
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override                       //   родитель  , нажатый элем,   позиция,   и id элемента
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // всплывающее  смс показывает позицию нажатого элемента
                Toast.makeText(getApplicationContext(), "позиция: " + position, Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), DrillCategoryActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), HammerDrillCategoryActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), GrinderCategoryActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

    }
}
