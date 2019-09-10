package com.example.mvvm_arch_components.utama.fragment.movies

import android.util.Log
import com.example.mvvm_arch_components.base.BasePresenter
import com.example.mvvm_arch_components.utils.rx.SchedulerProvider

class MoviesPresenter(
    view: MoviesContract.MoviesView,
    private val useCase: MoviesUseCase,
    private val subscriber: SchedulerProvider
) :
    BasePresenter<MoviesContract.MoviesView>(), MoviesContract.MoviesPresenter {

    init {
        super.onAttachView(view)
    }

    override fun getMovies() {
        view().onShowLoading()
        subscribe(useCase.getMovies()
        .observeOn(subscriber.mainThread())
        .subscribeOn(subscriber.io())
        .subscribe({
        Log.d("TAG", it.results.toString())
        view().onShowMovies(it.results)
        onFinish() }, this::catchError))
    }
}