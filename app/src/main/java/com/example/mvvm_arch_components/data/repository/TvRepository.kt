package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.data.entity.ResponseTv
import io.reactivex.Flowable
import org.intellij.lang.annotations.Flow

interface TvRepository {

    fun getTv() : Flowable<ResponseTv>
    fun getErrorTv() : Flowable<ResponseTv>
}