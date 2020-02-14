package com.example.kotlinissues.presentation.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) {
    observe(owner, androidx.lifecycle.Observer { observer(it) })
}