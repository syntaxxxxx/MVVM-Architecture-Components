package com.example.mvvm_arch_components.utama.fragment.tv.di

import com.example.mvvm_arch_components.data.di.DataModule
import com.example.mvvm_arch_components.data.di.DataScope
import com.example.mvvm_arch_components.data.repository.TvRepository
import com.example.mvvm_arch_components.data.repository.TvRepositoryImpl
import com.example.mvvm_arch_components.network.Routes
import com.example.mvvm_arch_components.utama.fragment.tv.TvShowContract
import com.example.mvvm_arch_components.utama.fragment.tv.TvShowPresenter
import com.example.mvvm_arch_components.utama.fragment.tv.TvShowUseCase
import com.example.mvvm_arch_components.utils.rx.AppSchedulerProvider
import com.example.mvvm_arch_components.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class TvModule {

    @TvScope
    @Provides
    fun provideRepository(@DataScope routes: Routes): TvRepository = TvRepositoryImpl(routes)

    @TvScope
    @Provides
    fun provideUseCase(repository: TvRepository): TvShowUseCase = TvShowUseCase(repository)

    @TvScope
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @TvScope
    @Provides
    fun providePresenter(useCase: TvShowUseCase, schedulerProvider: SchedulerProvider): TvShowContract.TvPresenter =
    TvShowPresenter(useCase, schedulerProvider)
}