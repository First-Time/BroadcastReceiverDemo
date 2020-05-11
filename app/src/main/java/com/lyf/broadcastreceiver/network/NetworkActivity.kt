package com.lyf.broadcastreceiver.network

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lyf.broadcastreceiver.R

class NetworkActivity : AppCompatActivity() {
    private val TAG = "Receiver"

    private lateinit var receiver: NetworkReceiver
    private lateinit var filter: IntentFilter

    private lateinit var manager: ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        /*receiver = NetworkReceiver()
        filter = IntentFilter()
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receiver, filter)*/

        manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                Log.i(TAG, "网络已连接")
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                Log.i(TAG, "网络已断开")
            }

            override fun onUnavailable() {
                super.onUnavailable()
                Log.i(TAG, "网络不可用")
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                Log.i(TAG, "onCapabilitiesChanged")
                if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                    if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i(TAG, "onCapabilitiesChanged: 网络类型为Wifi")
                    } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i(TAG, "onCapabilitiesChanged: 网络类型为蜂窝网络")
                    } else {
                        Log.i(TAG, "onCapabilitiesChanged: 网络类型为其他")
                    }
                }
            }

            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties)
                Log.i(TAG, "onLinkPropertiesChanged")
            }
        }

        manager.registerDefaultNetworkCallback(networkCallback)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDestroy() {
        super.onDestroy()
        manager.unregisterNetworkCallback(networkCallback)
    }
}
