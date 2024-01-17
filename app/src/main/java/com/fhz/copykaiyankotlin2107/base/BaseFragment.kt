package com.fhz.copykaiyankotlin2107.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.fhz.copykaiyankotlin2107.R

/**
 * 时间:2024/1/17
 * @author Mr.Feng
 * 简述: TODO
 */
abstract class BaseFragment<V: ViewBinding> : Fragment(){

     lateinit var binding: V
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = getViewBinding()
        initView()
        return binding.root
    }

    abstract fun initView()
    abstract fun getViewBinding():V
}