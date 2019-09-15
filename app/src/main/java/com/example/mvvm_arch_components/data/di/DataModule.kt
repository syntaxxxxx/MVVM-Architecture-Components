package com.example.mvvm_arch_components.data.di

import com.example.mvvm_arch_components.network.Network.services
import com.example.mvvm_arch_components.network.Routes
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides @DataScope
    fun provideRoutes() : Routes = services()
}