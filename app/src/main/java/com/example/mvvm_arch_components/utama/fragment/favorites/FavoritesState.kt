package com.example.mvvm_arch_components.utama.fragment.favorites

sealed class FavoritesState {

    object Show : FavoritesState()
    object Hide : FavoritesState()

    data class Success(val error: Exception)
    data class Error(val error: Exception)

}