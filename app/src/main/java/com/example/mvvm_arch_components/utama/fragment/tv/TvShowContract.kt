package com.example.mvvm_arch_components.utama.fragment.tv

import com.example.mvvm_arch_components.base.BaseContract
import com.example.mvvm_arch_components.data.entity.Tv

interface TvShowContract {

    interface TvPresenter : BaseContract.BasePresenter<TvView>{
        fun getTv()
    }

    interface TvView : BaseContract.BaseView{
        fun onShowTv(data: List<Tv>)
    }

}