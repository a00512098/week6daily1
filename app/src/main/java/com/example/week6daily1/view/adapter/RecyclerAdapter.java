package com.example.week6daily1.view.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.week6daily1.R;
import com.example.week6daily1.model.photos.Item;
import com.example.week6daily1.view.fullimageactivity.FullImageActivity;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements AdapterContract{
    List<Item> photos;
    AdapterPresenter presenter;

    public RecyclerAdapter(List<Item> photos) {
        this.photos = photos;
        presenter = new AdapterPresenter(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_photos, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Item photo = photos.get(i);
        final Context context = viewHolder.itemView.getContext();
        String title = context.getResources().getString(R.string.title_s);
        String date = context.getResources().getString(R.string.date_take_s);

        viewHolder.titleLabel.setText(String.format(title, photo.getTitle()));
        viewHolder.dateTakenLabel.setText(String.format(date, photo.getDateTaken()));

        Glide.with(context).load(photo.getMedia().getM()).into(viewHolder.thumbnail);

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                presenter.createListDialog(v.getContext(), photo).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleLabel;
        TextView dateTakenLabel;
        ImageView thumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleLabel = itemView.findViewById(R.id.titleLable);
            dateTakenLabel = itemView.findViewById(R.id.dateTakenLabel);
            thumbnail = itemView.findViewById(R.id.imageThumbnail);
        }
    }
}
