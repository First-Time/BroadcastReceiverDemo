package com.lyf.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class StaticReceiver : BroadcastReceiver() {
    private val TAG = "Static Receiver"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.i(TAG, "onReceiver：接收到一条广播：${intent.action}")
    }
}
