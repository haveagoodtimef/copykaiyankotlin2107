package com.fhz.copykaiyankotlin2107

import androidx.fragment.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.fhz.copykaiyankotlin2107.base.BaseActivity
import com.fhz.copykaiyankotlin2107.databinding.ActivityMainBinding
import com.fhz.copykaiyankotlin2107.ui.community.CommunityFragment
import com.fhz.copykaiyankotlin2107.ui.home.HomeFragment
import com.fhz.copykaiyankotlin2107.ui.message.MessageFragment
import com.fhz.copykaiyankotlin2107.ui.mine.MineFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    lateinit var homeFragment: Fragment
    lateinit var messageFragment: Fragment
    lateinit var communityFragment: Fragment
    lateinit var mineFragment: Fragment

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        initFragment()
        //初始化导航
        binding.bottomNavigationBar
            .addItem(BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页"))
            .addItem(BottomNavigationItem(R.drawable.ic_book_white_24dp, "社区"))
            .addItem(BottomNavigationItem(R.drawable.ic_message_white_24dp, "消息"))
            .addItem(BottomNavigationItem(R.drawable.ic_mine_white_24dp, "我的"))
            .setFirstSelectedPosition(0)
            .initialise()

        binding.bottomNavigationBar.setTabSelectedListener(object :
            BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                when (position) {
                    0 -> showFragment(homeFragment)
                    1 -> showFragment(communityFragment)
                    2 -> showFragment(messageFragment)
                    3 -> showFragment(mineFragment)
                }
            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabReselected(position: Int) {

            }
        })


    }

    private fun initFragment() { //事务
        val beginTransaction = supportFragmentManager.beginTransaction()
        homeFragment = HomeFragment.newInstance()
        messageFragment = MessageFragment.newInstance()
        communityFragment = CommunityFragment.newInstance()
        mineFragment = MineFragment.newInstance()
        beginTransaction.add(R.id.fragment_container_view, homeFragment)
        beginTransaction.add(R.id.fragment_container_view, messageFragment)
        beginTransaction.add(R.id.fragment_container_view, communityFragment)
        beginTransaction.add(R.id.fragment_container_view, mineFragment)
        beginTransaction.commit()
        showFragment(homeFragment)
    }

    private fun showFragment(fragment: Fragment) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        hideFragment()
        beginTransaction.show(fragment)
        beginTransaction.commit()
    }

    private fun hideFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.hide(homeFragment)
        beginTransaction.hide(messageFragment)
        beginTransaction.hide(communityFragment)
        beginTransaction.hide(mineFragment)
        beginTransaction.commit()
    }

}