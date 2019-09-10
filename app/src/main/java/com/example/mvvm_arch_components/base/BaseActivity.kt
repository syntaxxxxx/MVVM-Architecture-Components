package com.example.mvvm_arch_components.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast

abstract class BaseActivity<out P : BasePresenter<*>> : AppCompatActivity(), BaseContract.BaseView {

    private lateinit var presenter: P
    protected abstract fun presenter(): P
    protected abstract fun setContentView(): Int
    protected abstract fun onCreated()

    protected lateinit var savedInstanceState: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.savedInstanceState = savedInstanceState!!
        setContentView(setContentView())
        presenter = presenter()
        onCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDettachView()
    }

    override fun onShowLoading() {
        Log.d("TAG", "show loading !")
    }

    override fun onHideLoading() {
        Log.d("TAG", "hide loading !")
    }

    override fun onError(msg: String?) {

    }

    override fun onError(resId: Int) = onError(getString(resId))

    fun context(): Context = this
}