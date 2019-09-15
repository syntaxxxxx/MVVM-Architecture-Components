package com.example.mvvm_arch_components.utama.fragment.movies

import com.example.mvvm_arch_components.data.entity.ResponseMovies
import com.example.mvvm_arch_components.data.repository.MoviesRepository
import com.example.mvvm_arch_components.data.repository.MoviesRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) {
    fun getMovies() : Flowable<ResponseMovies> = repository.getMovies()
}