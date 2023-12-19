package com.aayush.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static my_custom_adaptors adaptors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        planetArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Mercury","0", R.drawable.mercury);
        Planet planet2 = new Planet("Venus","0", R.drawable.venus);
        Planet planet3 = new Planet("Earth","1", R.drawable.earth);
        Planet planet4 = new Planet("Mars","2", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter","79", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn","83", R.drawable.saturn);
        Planet planet7 = new Planet("Uranus","27", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune","14", R.drawable.neptune);
        Planet planet9 = new Planet("Pluto","0", R.drawable.pluto);

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);
        planetArrayList.add(planet9);

        adaptors = new my_custom_adaptors(planetArrayList,getApplicationContext());

        listView.setAdapter(adaptors);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet Name: " + Objects.requireNonNull(adaptors.getItem(position)).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}