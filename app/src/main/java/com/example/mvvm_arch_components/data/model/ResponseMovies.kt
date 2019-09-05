package com.example.mvvm_arch_components.data.model

import com.google.gson.annotations.SerializedName

data class ResponseMovies(
    @SerializedName("results") val result: List<Movies>
)

data class Movies(
    val id: String,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val overview: String,
    val releaseDate: String
)