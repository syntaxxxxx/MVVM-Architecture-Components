package com.example.mvvm_arch_components.base

import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException
import java.net.SocketTimeoutException

open class BasePresenter<V : BaseContract.BaseView> : BaseContract.BasePresenter<V> {

    private lateinit var _view: V
    private var composite: CompositeDisposable = CompositeDisposable()

    fun subscribe(disposable: Disposable) {
        composite.add(disposable)
    }

    override fun onFinish() {
        view().onHideLoading()
    }

    override fun catchError(error: Throwable?) = try {
        Log.e("TAG", error?.message!!)
        view().onHideLoading()
        when (error) {
            is HttpException -> view().onError(error.message())
            is SocketTimeoutException -> view().onError(error.message)
            is IOException -> view().onError(error.message)
            else -> view().onError(error.message)
        }

    } catch (e: Exception) {
        view().onError(e.message)
    }

    override fun onAttachView(view: V?) {
        if (view != null) {
            this._view = view
        } else{
            throw NullPointerException("View is null : Please attach your view on onCreated()")
        }
    }

    override fun onDettachView() {
        composite.clear()
    }

    override fun view(): V = _view
}