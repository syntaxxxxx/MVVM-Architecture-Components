package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.network.Network.services
import com.example.mvvm_arch_components.network.Routes
import org.junit.Before
import org.junit.Test

class MoviesRepositoryImplTest {

    lateinit var routes: Routes

    @Before
    fun setUp() {
        routes = services()
    }

    @Test
    fun getMovies() {
        val data = routes.getMovies()
        data.forEach(::println)
    }

    @Test
    fun getErrorMovies() {
        val error404 = routes.getErrorMovies()
        error404.forEach(::println)
    }
}