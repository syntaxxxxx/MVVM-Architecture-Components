package com.setyongr.nolsatu_android.common.extensions

import com.example.mvvm_arch_components.MoviesApp

fun Int.resString() = MoviesApp.getContext().getString(this)