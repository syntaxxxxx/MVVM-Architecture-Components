@file:Suppress("DEPRECATION")

package com.example.mvvm_arch_components.utama.detail

import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.example.mvvm_arch_components.BuildConfig
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.base.BaseActivity
import com.example.mvvm_arch_components.data.db.FavoriteMovies
import com.example.mvvm_arch_components.data.entity.Movies
import com.example.mvvm_arch_components.utama.detail.di.DaggerDetailMoviesComponent
import com.example.mvvm_arch_components.utama.detail.di.DetailMoviesModule
import com.example.mvvm_arch_components.utils.view.displayImageOriginal
import kotlinx.android.synthetic.main.activity_detail_movies.*
import javax.inject.Inject

class DetailMovies : BaseActivity(), DetailContract.DetailView {

    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null

    lateinit var movies: Movies

    @Inject lateinit var presenter: DetailContract.DetailPresenter

    override fun setContentView(): Int = R.layout.activity_detail_movies

    override fun onCreated() {
        movies = intent.getParcelableExtra("movies") as Movies
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.onAttachView(this)

        presenter.favState(this, movies.id)

        initData()
    }

    override fun initInjector() {
        DaggerDetailMoviesComponent.builder()
            .detailMoviesModule(DetailMoviesModule())
            .build()
            .inject(this)
    }

    private fun initData() {
        displayImageOriginal(this, iv_poster_detail, BuildConfig.IMAGES + movies.posterPath)
        tv_title_detail.text = movies.title
        tv_popularity_detail.text = movies.popularity.toString()
        tv_release_detail.text = movies.releaseDate
        tv_overview_detail.text = movies.overview
    }

    override fun setFavState(fav: List<FavoriteMovies>) {
        if (!fav.isEmpty()) isFavorite = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movies_menu, menu)
        menuItem = menu
        setLike()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.fav -> {
                if (isFavorite) {
                    presenter.unlike(this, movies.id)
                    isFavorite = !isFavorite

                } else {
                    presenter.like(this, movies)
                    isFavorite = !isFavorite
                }
                setLike()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun setLike() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_black_24dp)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_border_black_24dp)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDettachView()
    }
}