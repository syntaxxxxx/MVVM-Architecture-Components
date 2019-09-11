package com.example.mvvm_arch_components.utama.detail

import android.content.Context
import com.example.mvvm_arch_components.data.entity.Movies
import com.example.mvvm_arch_components.data.repository.LocalRepositoryImpl

class DetailUseCase(private val repositoryImpl: LocalRepositoryImpl) {

    fun like(context: Context, movies: Movies) = repositoryImpl.like(context, movies)
    fun unlike(context: Context, id: String) = repositoryImpl.unlike(context, id)
    fun favState(context: Context, id: String) = repositoryImpl.favState(context, id)

}