package com.example.mvvm_arch_components.utama.fragment.favorites.tv


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mvvm_arch_components.R

/**
 * A simple [Fragment] subclass.
 *
 */
class TvFavorites : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_favorites, container, false)
    }


}
