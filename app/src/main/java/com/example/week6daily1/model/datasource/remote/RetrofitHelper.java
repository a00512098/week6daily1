package com.example.week6daily1.model.datasource.remote;

import com.example.week6daily1.model.photos.PhotosResponse;
import com.google.gson.internal.GsonBuildConfig;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week6daily1.model.datasource.remote.RetrofitHelper.PATH;

public class RetrofitHelper {
    Retrofit retrofit;

    public static final String BASE_URL = "https://api.flickr.com/services/feeds/";
    public static final String PATH = "photos_public.gne?tag=kitten&format=json&nojsoncallback=1";

    public RetrofitHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private FlickrService getPhotosResponse() {
        return retrofit.create(FlickrService.class);
    }

    public Call<PhotosResponse> getPhotos() {
        return getPhotosResponse().getPhotos();
    }
}

interface FlickrService {
    @GET(PATH)
    Call<PhotosResponse> getPhotos();
}
