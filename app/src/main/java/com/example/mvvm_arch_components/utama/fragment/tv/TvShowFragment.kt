package com.example.mvvm_arch_components.utama.fragment.tv


import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.adapter.MoviesAdapter
import com.example.mvvm_arch_components.adapter.TvAdapter
import com.example.mvvm_arch_components.base.BaseFragment
import com.example.mvvm_arch_components.data.entity.Tv
import com.example.mvvm_arch_components.data.repository.TvRepositoryImpl
import com.example.mvvm_arch_components.network.Network
import com.example.mvvm_arch_components.utils.rx.AppSchedulerProvider
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_tv_show.*


/**
 * A simple [Fragment] subclass.
 *
 */
class TvShowFragment : BaseFragment<TvShowPresenter>(), TvShowContract.TvView {

    private val routes = Network.services()
    private val repository = TvRepositoryImpl(routes)
    private val useCase = TvShowUseCase(repository)

    private val dataTv = arrayListOf<Tv>()

    // using lazy for inisialisasi
    private val adapter: TvAdapter by lazy {
        TvAdapter(context(), dataTv)
    }

    override fun presenter(): TvShowPresenter = TvShowPresenter(this, useCase, AppSchedulerProvider())

    override fun setContentView(): Int = R.layout.fragment_tv_show

    override fun onCreated() {
        presenter().onAttachView(this)
        presenter().getTv()
    }

    @SuppressLint("WrongConstant")
    override fun onShowTv(data: List<Tv>) {
        rv_tv.setHasFixedSize(true)
        rv_tv.layoutManager = LinearLayoutManager(context(), LinearLayoutManager.VERTICAL, false)
        dataTv.clear()
        dataTv.addAll(data)
        adapter.notifyDataSetChanged()
        rv_tv.adapter = adapter
    }
}
