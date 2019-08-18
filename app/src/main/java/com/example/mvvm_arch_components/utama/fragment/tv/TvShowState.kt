package com.example.mvvm_arch_components.utama.fragment.tv

import java.lang.Exception

sealed class TvShowState {

    object Show : TvShowState()
    object Hide : TvShowState()

    data class Success(val error: Exception) : TvShowState()
    data class Error(val error: Exception) : TvShowState()
}