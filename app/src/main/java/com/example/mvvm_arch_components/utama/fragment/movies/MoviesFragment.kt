package com.example.mvvm_arch_components.utama.fragment.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.adapter.MyAdapter
import com.example.mvvm_arch_components.base.BaseFragment
import com.example.mvvm_arch_components.data.entity.Movies
import com.example.mvvm_arch_components.data.repository.MoviesRepositoryImpl
import com.example.mvvm_arch_components.network.Network
import com.example.mvvm_arch_components.utils.rx.AppSchedulerProvider
import kotlinx.android.synthetic.main.fragment_movies.*


/**
 * A simple [Fragment] subclass.
 *
 */
class MoviesFragment : BaseFragment<MoviesPresenter>(), MoviesContract.MoviesView {

    val routes = Network.services()
    val repository = MoviesRepositoryImpl(routes)
    val useCase = MoviesUseCase(repository)

    private val moviesData = arrayListOf<Movies>()

    // using lazy for inisialisasi
    private val adapter: MyAdapter by lazy {
        MyAdapter(context, moviesData)
    }

    override fun presenter(): MoviesPresenter = MoviesPresenter(this, useCase, AppSchedulerProvider())

    override fun setContentView(): Int = R.layout.fragment_movies

    override fun onCreated() {
        presenter().onAttachView(this)
        presenter().getMovies()
    }

    @SuppressLint("WrongConstant")
    override fun onShowMovies(data: List<Movies>) {
        rv_movies.setHasFixedSize(true)
        rv_movies.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        moviesData.clear()
        moviesData.addAll(data)
        adapter.notifyDataSetChanged()
        rv_movies.adapter = adapter
    }
}
