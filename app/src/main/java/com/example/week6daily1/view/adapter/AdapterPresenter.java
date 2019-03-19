package com.example.week6daily1.view.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.week6daily1.R;
import com.example.week6daily1.model.photos.Item;
import com.example.week6daily1.view.fullimageactivity.FullImageActivity;

public class AdapterPresenter {
    AdapterContract adapterContract;

    public AdapterPresenter(AdapterContract adapterContract) {
        this.adapterContract = adapterContract;
    }

    public Dialog createListDialog(final Context context, final Item photo) {
        String[] options = context.getResources().getStringArray(R.array.dialog_options);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.select_picture));
        builder.setItems(options, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        showFullImage(context, photo);
                        break;
                    case 1:
                        showSmallImage(context, photo);
                        break;
                }
            }
        });
        return builder.create();
    }

    public void showFullImage(Context context, Item photo) {
        Intent intent = new Intent(context, FullImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("item", photo);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void showSmallImage(Context context, Item photo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.small_image_dialog, null);
        ImageView imageView = view.findViewById(R.id.smallImage);
        builder.setView(view);
        Glide.with(context).load(photo.getMedia().getM()).into(imageView);
        builder.create().show();
    }
}

