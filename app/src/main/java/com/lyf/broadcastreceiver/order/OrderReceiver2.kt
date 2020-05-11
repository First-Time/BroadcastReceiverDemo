package com.lyf.broadcastreceiver.order

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class OrderReceiver2 : BroadcastReceiver() {
    private val TAG = "Order Receiver2"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.i(TAG, "onReceiver：接收到一条广播：${intent.action}")
        val extras = getResultExtras(true)
        extras?.putString("city", "北京")
        setResultExtras(extras)
//        abortBroadcast()
    }
}
