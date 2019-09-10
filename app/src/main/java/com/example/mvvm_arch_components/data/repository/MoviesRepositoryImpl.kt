package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.data.entity.ResponseMovies
import com.example.mvvm_arch_components.network.Routes
import io.reactivex.Flowable

class MoviesRepositoryImpl(private val routes: Routes) : MoviesRepository {

    /**
     * @getErrorMovies() testing purpose
     * */
    override fun getMovies(): Flowable<ResponseMovies> = routes.getMovies()
    override fun getErrorMovies(): Flowable<ResponseMovies> = routes.getErrorMovies()

}