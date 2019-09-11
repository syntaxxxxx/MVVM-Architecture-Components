package com.example.mvvm_arch_components.data.db

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class FavoriteMovies(
    val id: Long?,
    val idMovies: String?,
    val titleMovies: String?,
    val popMovies: String?,
    val dateMovies: String?,
    val overviewMovies: String?,
    val urlImages: String?
) : Parcelable {

    companion object {
        const val TABLE_MOVIES: String = "TABLE_MOVIES"
        const val _ID: String = "ID_"
        const val ID_MOVIES: String = "ID_MOVIES"
        const val TITLE_MOVIES: String = "NAME_MOVIES"
        const val POP_MOVIES: String = "POP_MOVIES"
        const val DATE_MOVIES: String = "DATE_MOVIES"
        const val OVERVIEW_MOVIES: String = "OVERVIEW_MOVIES"
        const val IMAGES: String = "IMAGES_MOVIES"
    }
}