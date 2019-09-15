package com.example.mvvm_arch_components.data.repository

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import com.example.mvvm_arch_components.data.db.FavoriteMovies
import com.example.mvvm_arch_components.data.db.database
import com.example.mvvm_arch_components.data.entity.Movies
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.select
import javax.inject.Inject

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class LocalRepositoryImpl @Inject constructor() : LocalRepository {

    override fun like(context: Context, movies: Movies) {
        try {
            context.database.use {
                insert(
                    FavoriteMovies.TABLE_MOVIES,
                    FavoriteMovies.ID_MOVIES to movies.id,
                    FavoriteMovies.TITLE_MOVIES to movies.title,
                    FavoriteMovies.POP_MOVIES to movies.popularity,
                    FavoriteMovies.DATE_MOVIES to movies.releaseDate,
                    FavoriteMovies.OVERVIEW_MOVIES to movies.overview,
                    FavoriteMovies.IMAGES to movies.posterPath
                )
            }
        } catch (e: SQLiteConstraintException) {
            error(e.localizedMessage)
        }
    }

    override fun unlike(context: Context, idMovies: String) {
        try {
            context.database.use {
                delete(
                    FavoriteMovies.TABLE_MOVIES, "(ID_MOVIES = {id})",
                    "id" to idMovies
                )
            }
        } catch (e: SQLiteConstraintException) {
            error(e.localizedMessage)
        }
    }

    override fun favState(context: Context, id:String): List<FavoriteMovies> {
        return context.database.use {
            val result = select(FavoriteMovies.TABLE_MOVIES)
                .whereArgs(
                    "(ID_MOVIES = {id})",
                    "id" to id
                )
            val fav = result.parseList(classParser<FavoriteMovies>())
            fav
        }
    }
}