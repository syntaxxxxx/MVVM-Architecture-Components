package com.example.mvvm_arch_components.utils.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions


/**
 * inflate for your layout
 * */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

/**
 * interface for event listener
 * */
inline fun View.onClicked(crossinline listener: () -> Unit) {
    setOnClickListener { listener() }
}

fun displayImageOriginal(context: Context, imageView: ImageView, url: String) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .apply(RequestOptions())
        .into(imageView)
}

fun displayImageThumbnail(context: Context, imageView: ImageView, url: Any, thumb: Float) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .apply(RequestOptions())
        .thumbnail(thumb)
        .into(imageView)
}

fun displayImageAsBitmap(context: Context, imageView: ImageView, url: Any) {
    Glide.with(context)
        .asBitmap()
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .apply(RequestOptions().transform(CircleCrop()))
        .into(imageView)
}
