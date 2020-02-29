package com.example.kotlinissues.presentation.util

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinissues.R

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_avatar_user)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun Fragment.setupToolbar(toolbar: Toolbar?) {
    (activity as? AppCompatActivity)
        ?.setSupportActionBar(toolbar)
}