package com.fhz.copykaiyankotlin2107.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * 时间:2024/1/17
 * @author Mr.Feng
 * 简述: TODO
 */
class HomeFragmentAdapter(fragmentManager: FragmentManager, var list: List<Fragment>) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int = list.size


    override fun getItem(position: Int): Fragment {
        return list[position]
    }

}