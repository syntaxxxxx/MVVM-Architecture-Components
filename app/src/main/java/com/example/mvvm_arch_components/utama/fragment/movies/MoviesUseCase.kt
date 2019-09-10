package com.example.mvvm_arch_components.utama.fragment.movies

import com.example.mvvm_arch_components.data.entity.ResponseMovies
import com.example.mvvm_arch_components.data.repository.MoviesRepositoryImpl
import io.reactivex.Flowable

class MoviesUseCase(private val repositoryImpl: MoviesRepositoryImpl) {

    fun getMovies() : Flowable<ResponseMovies> = repositoryImpl.getMovies()
}