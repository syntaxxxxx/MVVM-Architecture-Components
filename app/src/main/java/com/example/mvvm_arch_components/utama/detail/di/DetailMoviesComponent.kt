package com.example.mvvm_arch_components.utama.detail.di

import com.example.mvvm_arch_components.utama.detail.DetailMovies
import dagger.Component

@DetailMoviesScope
@Component(modules = [DetailMoviesModule::class])
interface DetailMoviesComponent {
    fun inject(activity: DetailMovies)
}