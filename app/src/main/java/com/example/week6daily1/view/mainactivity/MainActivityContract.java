package com.example.week6daily1.view.mainactivity;

import com.example.week6daily1.model.photos.Item;

import java.util.List;

public interface MainActivityContract {
    void fillRecyclerView(List<Item> photos);
}
