package com.okawa.store.utils

import android.databinding.BindingAdapter
import android.support.v4.widget.ContentLoadingProgressBar
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.okawa.store.R

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:image")
    fun image(imageView: ImageView, path: String?) {
        Glide.with(imageView.context)
                .load(path)
                .apply(RequestOptions().placeholder(R.drawable.ic_placeholder_icon).centerCrop().dontAnimate())
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("bind:loading")
    fun loading(contentLoadingProgressBar: ContentLoadingProgressBar, loading: Boolean) {
        if(loading) contentLoadingProgressBar.show() else contentLoadingProgressBar.hide()
    }

    @JvmStatic
    @BindingAdapter("bind:applyColor")
    fun applyColor(textView: TextView, apply: Boolean) {
        apply ?: return
        textView.applyColorOnDrawable()
    }

}