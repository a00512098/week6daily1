package com.example.week6daily1.view.fullimageactivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.week6daily1.R;

public class FullImageActivity extends AppCompatActivity implements FullImageActivityContract {
    FullImageActivityPresenter presenter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        imageView = findViewById(R.id.imageView);

        presenter = new FullImageActivityPresenter(this);
        presenter.getPacealable(this);
    }

    @Override
    public void setImage(String URL) {
        Glide.with(this).load(URL).centerCrop().into(imageView);
    }
}
