package com.example.appharrypotter.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.appharrypotter.R

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_broken_image)
        .into(this)
}