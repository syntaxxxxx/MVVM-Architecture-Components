package com.setyongr.nolsatu_android.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class NavigatorViewModel: ViewModel() {

    private val _navigator = MutableLiveData<Navigator>()
    val navigator = _navigator as LiveData<Navigator>

    fun navigate(navigator: Navigator) {
        _navigator.value = navigator
    }
}