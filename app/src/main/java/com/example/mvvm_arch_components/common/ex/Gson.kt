package com.example.mvvm_arch_components.common.ex

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> String.fromJson(): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(this, type)
}

inline fun <reified T> T.toJson(): String {
    val type = object : TypeToken<T>() {}.type
    return Gson().toJson(this, type)
}
