package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.data.model.ResponseMovies
import io.reactivex.Flowable

interface MoviesRepository {

    fun getMovies(): Flowable<ResponseMovies>

}