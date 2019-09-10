package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.data.entity.ResponseTv
import com.example.mvvm_arch_components.network.Routes
import io.reactivex.Flowable

class TvRepositoryImpl(private val routes: Routes) : TvRepository {
    override fun getTv(): Flowable<ResponseTv> = routes.getTv()
    override fun getErrorTv(): Flowable<ResponseTv> = routes.getErrorTv()
}