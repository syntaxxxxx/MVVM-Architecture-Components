package com.example.mvvm_arch_components.utama.detail.di

import com.example.mvvm_arch_components.data.repository.LocalRepository
import com.example.mvvm_arch_components.data.repository.LocalRepositoryImpl
import com.example.mvvm_arch_components.utama.detail.DetailContract
import com.example.mvvm_arch_components.utama.detail.DetailPresenter
import com.example.mvvm_arch_components.utama.detail.DetailUseCase
import dagger.Module
import dagger.Provides

@Module
class DetailMoviesModule {

    @DetailMoviesScope
    @Provides
    fun provideRepository(): LocalRepository = LocalRepositoryImpl()

    @DetailMoviesScope
    @Provides
    fun provideUseCase(repository: LocalRepository): DetailUseCase = DetailUseCase(repository)

    @DetailMoviesScope
    @Provides
    fun providePresenter(useCase: DetailUseCase): DetailContract.DetailPresenter = DetailPresenter(useCase)
}