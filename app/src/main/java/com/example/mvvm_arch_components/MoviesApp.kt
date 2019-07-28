package com.example.mvvm_arch_components

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

class MoviesApp : Application() {

    companion object {
        private var context: WeakReference<Context>? = null

        fun getContext(): Context {
            return context?.get() ?: throw Error("No Context")
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = WeakReference(applicationContext)
    }
}