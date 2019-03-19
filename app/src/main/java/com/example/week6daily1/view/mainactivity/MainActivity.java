package com.example.week6daily1.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week6daily1.R;
import com.example.week6daily1.model.photos.Item;
import com.example.week6daily1.view.adapter.RecyclerAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    MainActivityPresenter presenter;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        presenter.initRecyclerView();
    }

    @Override
    public void fillRecyclerView(List<Item> photos) {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(photos);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
