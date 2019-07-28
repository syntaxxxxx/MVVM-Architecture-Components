package com.example.mvvm_arch_components.common.ex

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.setyongr.nolsatu_android.common.Navigator
import com.setyongr.nolsatu_android.common.NavigatorHandler
import com.setyongr.nolsatu_android.common.NavigatorViewModel

fun Fragment.setupNavigator(
    owner: LifecycleOwner,
    viewModel: NavigatorViewModel,
    useActivityHandler: Boolean = false
) {
    viewModel.navigator.observe(owner, Observer {
        it.navigate(requireContext())

        if (this is NavigatorHandler) {
            this.handleNavigation(it)
        }

        val handlerActivity = activity as? NavigatorHandler
        if (useActivityHandler && handlerActivity != null) {
            handlerActivity.handleNavigation(it)
        }
    })
}

fun Fragment.navigate(navigator: Navigator, useActivityHandler: Boolean = false) {
    navigator.navigate(requireContext())

    if (this is NavigatorHandler) {
        this.handleNavigation(navigator)
    }

    val handlerActivity = activity as?NavigatorHandler
    if (useActivityHandler && handlerActivity != null){
        handlerActivity.handleNavigation(navigator)
    }
}

inline fun <reified T: ViewModel> Fragment.fragmentViewModel() = lazy {
    ViewModelProviders.of(this).get(T::class.java)
}

inline fun <reified T: ViewModel> Fragment.activityViewModel() = lazy {
    ViewModelProviders.of(requireActivity()).get(T::class.java)
}