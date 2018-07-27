package com.okawa.store.utils

import android.databinding.BindingAdapter
import android.support.v4.widget.ContentLoadingProgressBar
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

    @JvmStatic
    @BindingAdapter("bind:loading")
    fun loading(contentLoadingProgressBar: ContentLoadingProgressBar, loading: Boolean) {
        if(loading) contentLoadingProgressBar.show() else contentLoadingProgressBar.hide()
    }

}