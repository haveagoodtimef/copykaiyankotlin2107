package com.fhz.copykaiyankotlin2107.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.fhz.copykaiyankotlin2107.R

/**
 * 时间:2024/1/16
 * @author Mr.Feng
 * 简述: TODO
 */
open class BaseActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}