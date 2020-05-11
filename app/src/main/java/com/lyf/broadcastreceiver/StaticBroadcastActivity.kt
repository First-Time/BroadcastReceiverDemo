package com.lyf.broadcastreceiver

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_static_broadcast.*

class StaticBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_broadcast)

        initListener()
    }

    private fun initListener() {
        btn_send_broadcast.setOnClickListener {
            val airPlaneIntent = Intent()
            airPlaneIntent.action = "com.lyf.static_broadcast"
            sendBroadcast(airPlaneIntent)
        }
    }
}
