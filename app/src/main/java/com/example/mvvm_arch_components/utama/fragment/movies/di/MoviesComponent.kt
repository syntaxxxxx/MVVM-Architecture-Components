package com.example.mvvm_arch_components.utama.fragment.movies.di

import com.example.mvvm_arch_components.utama.fragment.movies.MoviesFragment
import dagger.Component


@MoviesScope
@Component(modules = [MoviesModule::class])
interface MoviesComponent {

    fun inject(fragment: MoviesFragment)

}