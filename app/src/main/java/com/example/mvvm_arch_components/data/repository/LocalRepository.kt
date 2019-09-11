package com.example.mvvm_arch_components.data.repository

import android.content.Context
import com.example.mvvm_arch_components.data.db.FavoriteMovies
import com.example.mvvm_arch_components.data.entity.Movies

interface LocalRepository {

    fun like(context : Context, movies: Movies)

    fun unlike(context: Context, idMovies: String)

    fun favState(context: Context, id:String): List<FavoriteMovies>
}