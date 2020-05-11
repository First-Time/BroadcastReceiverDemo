package com.lyf.broadcastreceiver

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.broadcastreceiver.network.NetworkActivity
import com.lyf.broadcastreceiver.order.OrderActivity1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        btn_go_dynamic_broadcast.setOnClickListener {
            startActivity(Intent(this, DynamicBroadcastActivity::class.java))
        }

        btn_go_static_broadcast.setOnClickListener {
            startActivity(Intent(this, StaticBroadcastActivity::class.java))
        }

        btn_send_dynamic_broadcast.setOnClickListener {
            val dynamicIntent = Intent()
            dynamicIntent.action = "com.lyf.dynamic_broadcast"
            sendBroadcast(dynamicIntent)
        }

        btn_send_static_broadcast.setOnClickListener {
            val staticIntent = Intent()
            staticIntent.action = "com.lyf.static_broadcast"
            staticIntent.setClassName(this, "com.lyf.broadcastreceiver.StaticReceiver")
            sendBroadcast(staticIntent)
        }

        btn_go_order_1.setOnClickListener {
            startActivity(Intent(this, OrderActivity1::class.java))
        }

        btn_go_network.setOnClickListener {
            startActivity(Intent(this, NetworkActivity::class.java))
        }
    }
}
