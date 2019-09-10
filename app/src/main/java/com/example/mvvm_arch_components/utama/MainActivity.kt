package com.example.mvvm_arch_components.utama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvvm_arch_components.R
import com.example.mvvm_arch_components.utama.fragment.favorites.FavoritesFragment
import com.example.mvvm_arch_components.utama.fragment.movies.MoviesFragment
import com.example.mvvm_arch_components.utama.fragment.tv.TvShowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.bottom_navigation.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        openFragment(MoviesFragment())
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment = when (item.itemId) {
            R.id.nav_movies -> MoviesFragment()
            R.id.nav_tv_show -> TvShowFragment()
            R.id.nav_favorites -> FavoritesFragment()
            else -> MoviesFragment()
        }
        openFragment(fragment)
        true
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment).commit()
    }
}

