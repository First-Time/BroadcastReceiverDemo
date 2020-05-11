package com.lyf.broadcastreceiver.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NetworkReceiver : BroadcastReceiver() {
    private val TAG = "Receiver"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        when (NetworkUtils().getConnectState(context)) {
            NetworkState.MOBILE -> Log.i(TAG, "当前连接了移动数据")
            NetworkState.WIFI -> Log.i(TAG, "当前连接了Wifi")
            NetworkState.UN_CONNECTED -> Log.i(TAG, "当前没有网络连接")
        }
    }
}
