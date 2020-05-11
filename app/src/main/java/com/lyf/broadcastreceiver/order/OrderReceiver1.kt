package com.lyf.broadcastreceiver.order

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class OrderReceiver1 : BroadcastReceiver() {
    private val TAG = "Order Receiver1"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.i(TAG, "onReceiver：接收到一条广播：${intent.action}")
        val extras = getResultExtras(true)
        Log.i(TAG, extras.getString("city", "没有地址"))

        context.startActivity(Intent(context, OrderActivity2::class.java))
    }
}
