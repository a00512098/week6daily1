package com.example.week6daily1.view.mainactivity;

import android.util.Log;

import com.example.week6daily1.model.datasource.remote.RetrofitHelper;
import com.example.week6daily1.model.photos.Item;
import com.example.week6daily1.model.photos.PhotosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter {
    MainActivityContract contract;
    RetrofitHelper retrofitHelper;

    public MainActivityPresenter(MainActivityContract contract) {
        this.contract = contract;
        retrofitHelper = new RetrofitHelper();
    }

    public void initRecyclerView() {
        retrofitHelper.getPhotos().enqueue(new Callback<PhotosResponse>() {
            @Override
            public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                List<Item> items  = response.body().getItems();
                contract.fillRecyclerView(items);
            }

            @Override
            public void onFailure(Call<PhotosResponse> call, Throwable t) {
                Log.d("Log.d", "Failed getting photos");
            }
        });
    }
}
