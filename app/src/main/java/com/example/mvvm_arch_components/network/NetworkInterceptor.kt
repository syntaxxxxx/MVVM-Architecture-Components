package com.example.mvvm_arch_components.network

import com.example.mvvm_arch_components.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    companion object {
        private const val PAGE_SIZE = 1
        private const val TOTAL_PAGE_SIZE = 5
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .addQueryParameter("language", BuildConfig.LANGUAGE)
            .addQueryParameter("page", PAGE_SIZE.toString())
            .addQueryParameter("total_page", TOTAL_PAGE_SIZE.toString())
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}