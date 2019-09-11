package com.example.mvvm_arch_components.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper private constructor(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "MyDatabase", null, 1) {

    init {
        instance = this
    }

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context) = instance ?: MyDatabaseOpenHelper(ctx.applicationContext)
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(
            FavoriteMovies.TABLE_MOVIES, true,
            FavoriteMovies._ID to INTEGER + PRIMARY_KEY,
            FavoriteMovies.ID_MOVIES to TEXT,
            FavoriteMovies.TITLE_MOVIES to TEXT,
            FavoriteMovies.POP_MOVIES to TEXT,
            FavoriteMovies.DATE_MOVIES to TEXT,
            FavoriteMovies.OVERVIEW_MOVIES to TEXT,
            FavoriteMovies.IMAGES to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(FavoriteMovies.TABLE_MOVIES, true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(this)