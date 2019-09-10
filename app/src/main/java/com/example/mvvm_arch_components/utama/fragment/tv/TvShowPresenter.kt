package com.example.mvvm_arch_components.utama.fragment.tv

import android.util.Log
import com.example.mvvm_arch_components.base.BasePresenter
import com.example.mvvm_arch_components.utils.rx.SchedulerProvider

class TvShowPresenter(
    view: TvShowContract.TvView,
    private val useCase: TvShowUseCase,
    private val subsriber: SchedulerProvider
) : BasePresenter<TvShowContract.TvView>(), TvShowContract.TvPresenter {

    init {
        super.onAttachView(view)
    }

    override fun getTv() {
        view().onShowLoading()
        subscribe(useCase.getTv()
        .observeOn(subsriber.mainThread())
        .subscribeOn(subsriber.io())
        .subscribe({
        Log.d("TAG", it.result.toString())
        view().onShowTv(it.result)
        onFinish() }, this::catchError))
    }
}