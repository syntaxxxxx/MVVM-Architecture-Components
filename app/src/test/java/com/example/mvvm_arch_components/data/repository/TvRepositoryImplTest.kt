package com.example.mvvm_arch_components.data.repository

import com.example.mvvm_arch_components.network.Network.services
import com.example.mvvm_arch_components.network.Routes
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvRepositoryImplTest {

    lateinit var routes: Routes

    @Before
    fun setUp() {
        routes = services()
    }

    @Test
    fun getTv() {
        val data = routes.getTv()
        data.forEach(::println)
    }

    @Test
    fun getErrorTv() {
        val error404 = routes.getErrorTv()
        error404.forEach(::println)
    }
}