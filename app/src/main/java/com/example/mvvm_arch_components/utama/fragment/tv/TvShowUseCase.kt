package com.example.mvvm_arch_components.utama.fragment.tv

import com.example.mvvm_arch_components.data.entity.ResponseTv
import com.example.mvvm_arch_components.data.repository.TvRepository
import io.reactivex.Flowable

class TvShowUseCase(private val repository: TvRepository) {

    fun getTv() : Flowable<ResponseTv> = repository.getTv()
}