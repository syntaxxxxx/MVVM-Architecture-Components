package com.example.mvvm_arch_components.utama.detail

import android.content.Context
import com.example.mvvm_arch_components.base.BaseContract
import com.example.mvvm_arch_components.data.db.FavoriteMovies
import com.example.mvvm_arch_components.data.entity.Movies

interface DetailContract {

    interface DetailPresenter : BaseContract.BasePresenter<DetailView> {
        fun like(context: Context, movies: Movies)

        fun unlike(context: Context, idMovies: String)

        fun favState(context: Context, id : String)
    }

    interface DetailView : BaseContract.BaseView {
        fun setFavState(fav: List<FavoriteMovies>)
    }
}