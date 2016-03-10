package com.kimeeo.kandroidBindingDemo;
import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by bhavinpadhiyar on 3/9/16.
 */



public class BindingAdapters {


    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView imageView, String imageUrl, Drawable drawable) {
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(drawable).into(imageView);
    }

    @BindingAdapter("iconText")
    public static void iconText(ImageView imageView, String icon) {

    }

    @BindingAdapter("iconText")
    public static void iconText(Button button, String icon) {

    }

    @BindingAdapter("iconText")
    public static void iconText(TextView button, String icon) {

    }
}
