package com.example.mvvm_arch_components.utama.detail

import android.content.Context
import com.example.mvvm_arch_components.base.BasePresenter
import com.example.mvvm_arch_components.data.entity.Movies

class DetailPresenter(
    view: DetailContract.DetailView,
    private val useCase: DetailUseCase
) : BasePresenter<DetailContract.DetailView>(), DetailContract.DetailPresenter {

    init {
        super.onAttachView(view)
    }

    override fun like(context: Context, movies: Movies) {
        useCase.like(context, movies)
        view().onSuccess("success to like")
    }

    override fun unlike(context: Context, idMovies: String) {
        useCase.unlike(context, idMovies)
        view().onSuccess("success to unlike")
    }

    override fun favState(context: Context, id: String) {
        view().setFavState(useCase.favState(context, id))
    }
}