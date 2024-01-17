package com.fhz.copykaiyankotlin2107

import android.app.Application
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp


/**
 * 时间:2024/1/17
 * @author Mr.Feng
 * 简述: TODO
 */

@HiltAndroidApp
class App : Application(){


    override fun onCreate() {
        super.onCreate()
        val rootDir = MMKV.initialize(this)
        println("mmkv root: $rootDir")
    }

}