package com.example.mvvm_arch_components.base

import androidx.annotation.StringRes

interface BaseContract {

    interface BasePresenter<V : BaseContract.BaseView> {
        fun onAttachView(view: V?)
        fun onDettachView()
        fun view(): V
        fun onFinish()
        fun catchError(error: Throwable?)
    }

    interface BaseView {
        fun onShowLoading()
        fun onHideLoading()
        fun onSuccess(string: String)
        fun onError(msg: String?)
        fun onError(@StringRes resId: Int)
    }
}