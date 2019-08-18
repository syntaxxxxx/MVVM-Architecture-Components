package com.example.mvvm_arch_components.utama.detail

sealed class DetailState {

    object Show : DetailState()
    object Hide : DetailState()

    data class Success(val error : Exception)
    data class Error(val error : Exception)
}