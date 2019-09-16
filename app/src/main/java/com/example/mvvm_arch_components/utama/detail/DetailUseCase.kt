package com.example.mvvm_arch_components.utama.detail

import android.content.Context
import com.example.mvvm_arch_components.data.entity.Movies
import com.example.mvvm_arch_components.data.repository.LocalRepository

class DetailUseCase(private val repository: LocalRepository) {

    fun like(context: Context, movies: Movies) = repository.like(context, movies)
    fun unlike(context: Context, id: String) = repository.unlike(context, id)
    fun favState(context: Context, id: String) = repository.favState(context, id)

}