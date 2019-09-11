package com.example.mvvm_arch_components.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.toast

abstract class BaseFragment<out P : BasePresenter<*>> : Fragment(), BaseContract.BaseView {

    private lateinit var presenter: P
    protected abstract fun presenter(): P
    protected abstract fun setContentView(): Int
    protected abstract fun onCreated()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(setContentView(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = presenter()
        onCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDettachView()
    }

    override fun onShowLoading() {
        Log.d("TAG", "show loading !")
    }

    override fun onHideLoading() {
        Log.d("TAG", "hide loading !")
    }

    override fun onSuccess(string: String) {
        context()?.toast(string)
    }

    override fun onError(msg: String?) {

    }

    override fun onError(resId: Int) {

    }

    fun context(): Context? = context

}