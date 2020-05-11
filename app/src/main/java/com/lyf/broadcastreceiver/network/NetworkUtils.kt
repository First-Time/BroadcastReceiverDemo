package com.lyf.broadcastreceiver.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build

class NetworkUtils {
    private var tempState = NetworkState.UN_CONNECTED

    fun getConnectState(context: Context): NetworkState {
        val manager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = manager.activeNetworkInfo
        var state = NetworkState.UN_CONNECTED
        if (networkInfo == null) {
            return state
        } else if (networkInfo?.isAvailable) {
            if (isWifiConnected(context)) {
                state = NetworkState.WIFI
            } else if (isMobileConnected(context)) {
                state = NetworkState.MOBILE
            }
        }
        if (state == tempState) {
            return NetworkState.PUBLISHED
        }
        tempState = state
        return state
    }

    private fun isMobileConnected(context: Context): Boolean {
        return isConnected(context, ConnectivityManager.TYPE_MOBILE)
    }

    private fun isWifiConnected(context: Context): Boolean {
        return isConnected(context, ConnectivityManager.TYPE_WIFI)
    }

    private fun isConnected(context: Context, type: Int): Boolean {
        val manager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            val allNetworkInfo = manager.allNetworkInfo
            for (info in allNetworkInfo) {
                val state = info.state
                if (state != null && state == NetworkInfo.State.CONNECTED && info.type == type) {
                    return info.isAvailable
                }
            }
        } else {
            val networks = manager.allNetworks
            for (network in networks) {
                val networkInfo = manager.getNetworkInfo(type)
                val state = networkInfo.state
                if (state != null && state == NetworkInfo.State.CONNECTED && networkInfo.type == type) {
                    return networkInfo.isAvailable
                }
            }
        }
        return false
    }
}