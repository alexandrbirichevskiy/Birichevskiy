package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface ConnectionState {
    val connectionState: StateFlow<Boolean>
}

class ConnectionStateDelegate(
    context: Context
) : ConnectionState {

    private val _connectionState = MutableStateFlow(false)
    override val connectionState = _connectionState.asStateFlow()

    private var connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    init {
        registerNetworkCallback()
    }

    private fun registerNetworkCallback() {
        connectivityManager.registerDefaultNetworkCallback(
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    _connectionState.tryEmit(true)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    _connectionState.tryEmit(false)
                }
            }
        )
    }
}