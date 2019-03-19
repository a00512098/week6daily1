package com.example.week6daily1.view.fullimageactivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.week6daily1.model.photos.Item;

public class FullImageActivityPresenter {
    FullImageActivityContract contract;
    Item item;

    public FullImageActivityPresenter(FullImageActivityContract contract) {
        this.contract = contract;
    }

    public void getPacealable(FullImageActivity fullImageActivity) {
        Intent intent = fullImageActivity.getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                item = bundle.getParcelable("item");
                contract.setImage(item.getMedia().getM());
            }
        }
    }
}
