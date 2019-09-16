package com.example.mvvm_arch_components.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast

abstract class BaseActivity: AppCompatActivity(), BaseContract.BaseView {

    protected abstract fun setContentView(): Int
    protected abstract fun onCreated()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
        onCreated()
    }

    override fun onShowLoading() {
        Log.d("TAG", "show loading !")
    }

    override fun onHideLoading() {
        Log.d("TAG", "hide loading !")
    }

    override fun onSuccess(string: String) {
        toast(string)
    }

    override fun onError(msg: String?) {

    }

    override fun onError(resId: Int) = onError(getString(resId))

    fun context(): Context = this
}