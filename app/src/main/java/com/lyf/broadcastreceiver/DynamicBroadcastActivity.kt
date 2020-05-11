package com.lyf.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dynamic_broadcast.*

class DynamicBroadcastActivity : AppCompatActivity() {
    lateinit var mIntentFilter: IntentFilter
    lateinit var dynamicReceiver: DynamicReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_broadcast)

        initListener()

        mIntentFilter = IntentFilter()
        mIntentFilter.addAction("com.lyf.dynamic_broadcast")

        dynamicReceiver = DynamicReceiver()

        registerReceiver(dynamicReceiver, mIntentFilter)
    }

    private fun initListener() {
        btn_send_broadcast.setOnClickListener {
            val airPlaneIntent = Intent()
            airPlaneIntent.action = "com.lyf.dynamic_broadcast"
            sendBroadcast(airPlaneIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(dynamicReceiver)
    }
}
