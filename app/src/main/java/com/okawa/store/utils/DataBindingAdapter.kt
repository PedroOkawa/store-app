package com.okawa.store.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:image")
    fun image(imageView: ImageView, path: String?) {
        Glide.with(imageView.context)
                .load(path)
                .into(imageView)
    }

}