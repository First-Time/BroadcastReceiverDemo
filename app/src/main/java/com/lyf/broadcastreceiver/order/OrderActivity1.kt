package com.lyf.broadcastreceiver.order

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.broadcastreceiver.R
import kotlinx.android.synthetic.main.activity_order1.*

class OrderActivity1 : AppCompatActivity() {
    private lateinit var receiver1: OrderReceiver1
    private lateinit var filter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order1)

        initListener()

        receiver1 = OrderReceiver1()
        filter = IntentFilter()
        filter.addAction("com.lyf.ordered_broadcast")
        val intent1 = registerReceiver(receiver1, filter)
    }

    private fun initListener() {
        btn_send_broadcast.setOnClickListener {
            val myIntent = Intent()
            myIntent.action = "com.lyf.ordered_broadcast"
            sendOrderedBroadcast(myIntent, null)
        }

        btn_go_order_2.setOnClickListener {
            startActivity(Intent(this, OrderActivity2::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver1)
    }
}
