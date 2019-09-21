package com.example.mvvm_arch_components.utils.state

enum class Status {
    LOADING, SUCCESS, ERROR
}

data class NetworkState constructor(val status: Status, val msg: String? = null) {

    companion object {
        val LOADING = NetworkState(Status.LOADING)
        val SUCCESS = NetworkState(Status.SUCCESS)
        val ERROR = NetworkState(Status.ERROR)
        fun error(msg: String?) = NetworkState(Status.ERROR, msg)
    }
}