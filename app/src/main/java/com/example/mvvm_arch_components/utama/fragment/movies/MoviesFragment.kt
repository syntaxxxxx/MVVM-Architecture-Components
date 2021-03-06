package com.example.mvvm_arch_components.utama.fragment.movies

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.adapter.MoviesAdapter
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
class MoviesFragment : BaseFragment(), MoviesContract.MoviesView {

    private val moviesData = arrayListOf<Movies>()

    // using lazy for inisialisasi
    private val adapter: MoviesAdapter by lazy {
        MoviesAdapter(context(), moviesData)
    }

    lateinit var presenter: MoviesContract.MoviesPresenter

    override fun setContentView(): Int = R.layout.fragment_movies

    override fun onCreated() {
        val routes = Network.services()
        val repository = MoviesRepositoryImpl(routes)
        val useCase = MoviesUseCase(repository)
        presenter = MoviesPresenter(useCase, AppSchedulerProvider())
        presenter.onAttachView(this)
        presenter.getMovies()
    }

    @SuppressLint("WrongConstant")
    override fun onShowMovies(data: List<Movies>) {
        rv_movies.setHasFixedSize(true)
        rv_movies.layoutManager = LinearLayoutManager(context(), LinearLayoutManager.VERTICAL, false)
        moviesData.clear()
        moviesData.addAll(data)
        adapter.notifyDataSetChanged()
        rv_movies.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDettachView()
    }
}
