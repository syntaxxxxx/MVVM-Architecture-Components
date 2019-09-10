package com.example.mvvm_arch_components.utama.fragment.tv

import com.example.mvvm_arch_components.data.entity.ResponseTv
import com.example.mvvm_arch_components.data.repository.TvRepositoryImpl
import io.reactivex.Flowable

class TvShowUseCase(private val repositoryImpl: TvRepositoryImpl) {

    fun getTv() : Flowable<ResponseTv> = repositoryImpl.getTv()
}