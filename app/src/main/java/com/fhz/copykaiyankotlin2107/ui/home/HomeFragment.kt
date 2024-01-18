package com.fhz.copykaiyankotlin2107.ui.home

import android.content.Context
import android.graphics.Color
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.fhz.copykaiyankotlin2107.base.BaseFragment
import com.fhz.copykaiyankotlin2107.databinding.MainFragmentHomeBinding
import com.fhz.copykaiyankotlin2107.ui.home.adapter.HomeFragmentAdapter
import com.fhz.copykaiyankotlin2107.ui.home.ui.daily.DailyFragment
import com.fhz.copykaiyankotlin2107.ui.home.ui.find.FindFragment
import com.fhz.copykaiyankotlin2107.ui.home.ui.recommended.RecommendFragment
import dagger.hilt.android.AndroidEntryPoint
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView


@AndroidEntryPoint
class HomeFragment : BaseFragment<MainFragmentHomeBinding>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val mTitleDataList = listOf( "发现","推荐","日报")

    private lateinit var viewModel: HomeViewModel
    private lateinit var mViewPager: ViewPager
    private lateinit var magicIndicator: MagicIndicator
    override fun initView() {
        //初始化viewpager
        initViewPager()
        //初始化Tablayout
        initTablayout()
        //绑定viewpager
        ViewPagerHelper.bind(magicIndicator, mViewPager)
    }

    private fun initTablayout() {
        magicIndicator = binding.magicIndicator
        val commonNavigator = CommonNavigator(context)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int = mTitleDataList.size

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val colorTransitionPagerTitleView = ColorTransitionPagerTitleView(context)
                colorTransitionPagerTitleView.normalColor = Color.GRAY
                colorTransitionPagerTitleView.selectedColor = Color.BLACK
                colorTransitionPagerTitleView.text = mTitleDataList[index]
                colorTransitionPagerTitleView.setOnClickListener { mViewPager.currentItem = index }
                return colorTransitionPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                indicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
                return indicator
            }
        }
        magicIndicator.navigator = commonNavigator
    }

    private fun initViewPager() {
        mViewPager = binding.viewPager
        val list = mutableListOf<Fragment>()
        list.add(FindFragment.newInstance())
        list.add(RecommendFragment.newInstance())
        list.add(DailyFragment.newInstance())
        mViewPager.adapter = HomeFragmentAdapter(childFragmentManager,list)
    }

    override fun getViewBinding(): MainFragmentHomeBinding {
        return MainFragmentHomeBinding.inflate(layoutInflater)
    }




}