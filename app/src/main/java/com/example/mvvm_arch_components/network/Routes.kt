package com.example.mvvm_arch_components.network

import com.example.mvvm_arch_components.data.model.ResponseMovies
import com.example.mvvm_arch_components.data.model.ResponseTv
import io.reactivex.Flowable
import org.intellij.lang.annotations.Flow
import retrofit2.http.GET

interface Routes {

    @GET("discover/movie")
    fun getMovies() : Flowable<ResponseMovies>

    @GET("discover/movi")
    fun getErrorMovies() : Flowable<ResponseMovies>

    @GET("tv/popular")
    fun getTv() : Flowable<ResponseTv>

    @GET("tv/populars")
    fun getErrorTv() : Flowable<ResponseTv>

}