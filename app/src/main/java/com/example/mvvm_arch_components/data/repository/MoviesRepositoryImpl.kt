package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.data.model.ResponseMovies
import com.example.mvvm_arch_components.network.Routes
import io.reactivex.Flowable

class MoviesRepositoryImpl(private val routes: Routes) : MoviesRepository {

    override fun getMovies(): Flowable<ResponseMovies> = routes.getMovies()

}