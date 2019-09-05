package com.example.mvvm_arch_components.data.model

import com.google.gson.annotations.SerializedName

data class ResponseTv(
    @SerializedName("results") val result: List<Tv>
)

data class Tv(
    val id: String,
    val name: String,
    val popularity: Double,
    val posterPath: String,
    val overview: String
)