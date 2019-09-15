package com.example.mvvm_arch_components.utama.fragment.movies.di

import com.example.mvvm_arch_components.data.repository.MoviesRepository
import com.example.mvvm_arch_components.data.repository.MoviesRepositoryImpl
import com.example.mvvm_arch_components.data.di.DataModule
import com.example.mvvm_arch_components.data.di.DataScope
import com.example.mvvm_arch_components.network.Routes
import com.example.mvvm_arch_components.utama.fragment.movies.MoviesContract
import com.example.mvvm_arch_components.utama.fragment.movies.MoviesPresenter
import com.example.mvvm_arch_components.utama.fragment.movies.MoviesUseCase
import com.example.mvvm_arch_components.utils.rx.AppSchedulerProvider
import com.example.mvvm_arch_components.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class MoviesModule {

    @MoviesScope
    @Provides
    fun provideRepository(@DataScope routes: Routes): MoviesRepository = MoviesRepositoryImpl(routes)

    @MoviesScope
    @Provides
    fun provideUseCase(repository: MoviesRepository): MoviesUseCase = MoviesUseCase(repository)

    @MoviesScope
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @MoviesScope
    @Provides
    fun providePresenter(useCase: MoviesUseCase, schedulerProvider: SchedulerProvider): MoviesContract.MoviesPresenter =
        MoviesPresenter(useCase, schedulerProvider)
}