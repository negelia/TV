package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    ArrayList<Model> movies = new ArrayList<Model>();

    LinearLayoutManager HorizontalLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
        setData();
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, movies);
        recyclerView.setAdapter(adapter);

        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(HorizontalLayout);
    }
    private void setData(){

        movies.add(new Model (R.drawable.pic11, "The Budapest Hotel"));
        movies.add(new Model (R.drawable.pic22, "Moonrise Kingdom"));
        movies.add(new Model (R.drawable.pic333, "Royal Tenenbaums"));
    }
}