package com.example.mvvm_arch_components.utama.fragment.tv.di

import com.example.mvvm_arch_components.utama.fragment.tv.TvShowFragment
import dagger.Component

@TvScope
@Component(modules = [TvModule::class])
interface TvComponent {
    fun inject(fragment: TvShowFragment)
}