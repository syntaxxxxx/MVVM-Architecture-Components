package com.example.mvvm_arch_components.utama.fragment.movies

import java.lang.Exception

sealed class MoviesState {

    object Show : MoviesState()
    object Hide : MoviesState()

    data class Success(val error: Exception) : MoviesState()
    data class Error(val error: Exception) : MoviesState()

}