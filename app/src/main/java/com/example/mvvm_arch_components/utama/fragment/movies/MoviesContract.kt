package com.example.mvvm_arch_components.utama.fragment.movies

import com.example.mvvm_arch_components.base.BaseContract
import com.example.mvvm_arch_components.data.entity.Movies

interface MoviesContract {

    interface MoviesPresenter : BaseContract.BasePresenter<MoviesView>{
        fun getMovies()
    }

    interface MoviesView : BaseContract.BaseView{
        fun onShowMovies(data: List<Movies>)
    }
}