package com.fhz.copykaiyankotlin2107

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.tencent.mmkv.MMKV

class SplashActivity : AppCompatActivity() {

    private val  mHandler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ImmersionBar.with(this)
            .titleBar(findViewById(R.id.top_view))
            .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
            .hideBar(BarHide.FLAG_HIDE_BAR)
            .init()
        val boolean = MMKV.defaultMMKV().getBoolean("isFirst", true)

        if(!boolean){
            //三秒跳转
            mHandler.postDelayed(this::startMain, 3000)
            MMKV.defaultMMKV().putBoolean("isFirst", false)
        }else{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun startMain(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }



    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacksAndMessages(null)
    }
}