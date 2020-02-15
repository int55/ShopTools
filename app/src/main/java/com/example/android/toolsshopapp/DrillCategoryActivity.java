package com.example.android.toolsshopapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;
    private ArrayList<Tools> tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);

//скрываем actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        tools = new ArrayList<>();
        listViewDrills = findViewById(R.id.listViewDrills);
        tools.add(new Tools(getString(R.string.dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt_drill));
        tools.add(new Tools(getString(R.string.makita_title), getString(R.string.drill_makita_info), R.drawable.makita_drill));
        tools.add(new Tools(getString(R.string.bosch_title), getString(R.string.drill_bosch_info), R.drawable.bosch_drill));

        ArrayAdapter<Tools> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, tools);
        listViewDrills.setAdapter(adapter);

        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //получаем позицию элемента на котор кликнули
                Tools tools = DrillCategoryActivity.this.tools.get(position);

                Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
                intent.putExtra("title", tools.getTitle());
                intent.putExtra("info", tools.getInfo());
                intent.putExtra("resId", tools.getIdImageResource());
                startActivity(intent);
            }
        });
    }
}
