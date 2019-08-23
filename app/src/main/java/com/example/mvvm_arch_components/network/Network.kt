package com.example.mvvm_arch_components.network

import com.example.mvvm_arch_components.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Network {

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {

        /**
         * @BODY if you need show all response
         * @BASIC only show end_point response
         * @NONE nothing
         * */
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(NetworkInterceptor())
            .addInterceptor(provideLoggingInterceptor())
            .retryOnConnectionFailure(false)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
        return okHttpClient
    }

    private fun provideRetrofit(url: String = BuildConfig.BASE_URL): Retrofit {

        /**
         * setFieldNamingPolicy()
         * for convert lowercase with underscores
         * json:`user_name`, you can use `userName` as variable
         */
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    fun services(): Routes = provideRetrofit().create(Routes::class.java)

}