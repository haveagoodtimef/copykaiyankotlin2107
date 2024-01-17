package com.fhz.copykaiyankotlin2107.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.fhz.copykaiyankotlin2107.R

/**
 * 时间:2024/1/16
 * @author Mr.Feng
 * 简述: TODO
 */
abstract class BaseActivity<V:ViewBinding> :AppCompatActivity() {

     lateinit var binding: V


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getViewBinding()
        setContentView(binding.root)
        initView()
    }
    abstract fun initView()

    abstract fun getViewBinding():V
}