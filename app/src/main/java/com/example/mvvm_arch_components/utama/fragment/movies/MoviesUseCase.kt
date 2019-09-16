package com.example.mvvm_arch_components.utama.fragment.movies

import com.example.mvvm_arch_components.data.entity.ResponseMovies
import com.example.mvvm_arch_components.data.repository.MoviesRepository
import io.reactivex.Flowable

class MoviesUseCase(private val repository: MoviesRepository) {

    fun getMovies() : Flowable<ResponseMovies> = repository.getMovies()
}