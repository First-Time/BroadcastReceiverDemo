package com.lyf.broadcastreceiver.order

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyf.broadcastreceiver.R
import kotlinx.android.synthetic.main.activity_order_all.*

class OrderAllActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_all)

        initListener()
    }

    private fun initListener() {
        btn_send_broadcast.setOnClickListener {
            val myIntent = Intent()
            myIntent.action = "com.lyf.ordered_broadcast"
            sendOrderedBroadcast(myIntent, null)
        }
    }
}
