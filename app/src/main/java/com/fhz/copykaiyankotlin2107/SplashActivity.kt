package com.fhz.copykaiyankotlin2107

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private val  mHandler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //三秒跳转
        mHandler.postDelayed(this::startMain, 3000)

    }

    private fun startMain(){

        //欢迎页只出现一次

        startActivity(Intent(this, MainActivity::class.java))


        finish()
    }



    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacksAndMessages(null)
    }
}