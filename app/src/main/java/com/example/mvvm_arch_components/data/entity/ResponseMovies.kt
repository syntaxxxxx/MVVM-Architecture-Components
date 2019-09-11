package com.example.mvvm_arch_components.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseMovies(
    @SerializedName("results") val results: List<Movies>)

@Parcelize
data class Movies(
    val id: String,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val overview: String,
    val releaseDate: String
) : Parcelable