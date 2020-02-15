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

public class HammerDrillCategoryActivity extends AppCompatActivity {

    private ListView listViewHammerDrill;
    private ArrayList<Tools> hammerTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hammer_drill_category);

        //скрываем actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        hammerTools = new ArrayList<>();
        listViewHammerDrill = findViewById(R.id.listViewHammerDrills);

        hammerTools.add(new Tools(getString(R.string.dewalt_title), getString(R.string.hammer_drill_dewalt_info), R.drawable.dewalt_hammer_drill));
        hammerTools.add(new Tools(getString(R.string.makita_title), getString(R.string.hammer_drill_makita_info), R.drawable.makita_hammer_drill));
        hammerTools.add(new Tools(getString(R.string.bosch_title), getString(R.string.hammer_drill_bosch_info), R.drawable.bosch_hammer_drill));

        ArrayAdapter<Tools> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, hammerTools);
        listViewHammerDrill.setAdapter(adapter);
        listViewHammerDrill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Tools tools = hammerTools.get(position);

                Intent intent = new Intent(getApplicationContext(), HammerDrillDetailActivity.class);
                intent.putExtra("title", tools.getTitle());
                intent.putExtra("info", tools.getInfo());
                intent.putExtra("resId", tools.getIdImageResource());
                startActivity(intent);
            }
        });
    }
}
