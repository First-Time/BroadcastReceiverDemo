package com.lyf.broadcastreceiver.order

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.broadcastreceiver.R
import kotlinx.android.synthetic.main.activity_order2.*

class OrderActivity2 : AppCompatActivity() {
    private lateinit var receiver2: OrderReceiver2
    private lateinit var filter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order2)

        initListener()

        receiver2 = OrderReceiver2()
        filter = IntentFilter()
        filter.addAction("com.lyf.ordered_broadcast")
        filter.priority = 500
        val intent2 = registerReceiver(receiver2, filter)
//        val intent2 = registerReceiver(null, filter)
    }

    private fun initListener() {
        btn_send_broadcast.setOnClickListener {
            val myIntent = Intent()
            myIntent.action = "com.lyf.ordered_broadcast"
            myIntent.putExtra("lyf", "第一时间")
            sendOrderedBroadcast(myIntent, null)
        }

        btn_go_order_all.setOnClickListener {
            startActivity(Intent(this, OrderAllActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver2)
    }
}
