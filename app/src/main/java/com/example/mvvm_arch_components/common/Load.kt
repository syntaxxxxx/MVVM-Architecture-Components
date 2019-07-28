package com.setyongr.nolsatu_android.common

sealed class Load<out T> {
    object Uninitialized: Load<Nothing>()
    object Loading: Load<Nothing>()
    data class Fail<T>(val error: Throwable): Load<T>()
    data class Success<T: Any>(val data: T): Load<T>()
}
