package com.example.mvvm_arch_components.utama.fragment.movies

import com.example.mvvm_arch_components.data.Injection
import com.setyongr.nolsatu_android.common.NavigatorViewModel

class MoviesViewModel : NavigatorViewModel() {

    val service = Injection.provideApiService()

}