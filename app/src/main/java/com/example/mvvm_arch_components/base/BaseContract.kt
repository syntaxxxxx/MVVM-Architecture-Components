package com.example.mvvm_arch_components.base

import androidx.annotation.IdRes
import androidx.annotation.StringRes

interface BaseContract {

    interface BasePresenter<V> {
        fun onAttachView(view: V?)
        fun onDettachView()
        fun view(): V
        fun onFinish()
        fun catchError(error: Throwable)
    }

    interface BaseView {
        fun onShowLoading(msg: String?)
        fun onShowLoading(@StringRes resId: Int)
        fun onError(msg: String?)
        fun onError(@StringRes resId: Int)
    }
}