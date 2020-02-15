package com.example.android.toolsshopapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GrinderCategoryActivity extends AppCompatActivity {

    private ListView listViewGrinder;
    private ArrayList<Tools> tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grinder_category);

        //скрываем actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        tools = new ArrayList<>();
        listViewGrinder = findViewById(R.id.listViewGrinderXML);
        tools.add(new Tools(getString(R.string.dewalt_title), getString(R.string.grinder_tools_dewalt_info), R.drawable.dewalt_grinder_tools));
        tools.add(new Tools(getString(R.string.makita_title), getString(R.string.grinder_tools_makita_info), R.drawable.makita_grinder_tools));
        tools.add(new Tools(getString(R.string.bosch_title), getString(R.string.grinder_tools_bosch_info), R.drawable.bosch_grinder_tools));

        ArrayAdapter<Tools> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, tools);

        listViewGrinder.setAdapter(adapter);

        listViewGrinder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Tools tools = GrinderCategoryActivity.this.tools.get(position);
                Intent intent = new Intent(getApplicationContext(), GrinderDetailActivity.class);
                intent.putExtra("title", tools.getTitle());
                intent.putExtra("info", tools.getInfo());
                intent.putExtra("resId", tools.getIdImageResource());
                startActivity(intent);
            }
        });
    }
}
