package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.chad.baserecyclerviewadapterhelper.entity.HomeEntity
import com.fhz.copykaiyankotlin2107.R
import com.fhz.copykaiyankotlin2107.base.BaseFragment
import com.fhz.copykaiyankotlin2107.bean.Banner
import com.fhz.copykaiyankotlin2107.databinding.MainFragmentRecommendBinding
import com.fhz.copykaiyankotlin2107.ui.home.ui.recommended.adapter.RecommendFragmentRecyclerViewAdapter
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder
import com.zhpan.bannerview.constants.PageStyle
import dagger.hilt.android.AndroidEntryPoint


/**
 * 推荐页内容
 */
@AndroidEntryPoint
class RecommendFragment : BaseFragment<MainFragmentRecommendBinding>() {

    companion object {
        fun newInstance() = RecommendFragment()
    }

    private val viewModel: RecommendViewModel by viewModels()


    override fun initView() {
        //初始化recyclerview
        initRecyclerView()

        //初始化数据源
        viewModel.getRecommendData()

        //初始化banner
        binding.bannerView.setLifecycleRegistry(lifecycle)
            .setRoundCorner(10)
            .setOnPageClickListener { clickedView, position ->
                when(position){
                    0 -> {
                        //跳转到发现页
                        Toast.makeText(requireContext(),"发现", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        //跳转到推荐页
                        Toast.makeText(requireContext(),"推荐", Toast.LENGTH_SHORT).show()
                    }
                    2 -> {
                        //跳转到日报页
                    }}
            }
            .setPageStyle(PageStyle.MULTI_PAGE_OVERLAP)
            .setAdapter(object : BaseBannerAdapter<Banner>() {
                override fun bindData(
                    holder: BaseViewHolder<Banner>,
                    data: Banner,
                    position: Int,
                    pageSize: Int
                ) {
                    holder.itemView.let {
                        Glide.with(it)
                            .load(data.url)
                            .into(holder.findViewById(R.id.banner_image))
                    }
//                    holder?.setImageResource(R.id.banner_image,R.drawable.ic_book_white_24dp)

                }

                override fun getLayoutId(viewType: Int): Int {
                   return R.layout.main_banner_item_layout
                }
            })
            .create()

        val list = mutableListOf<Banner>()
        list.add(Banner("美女","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",1))
        list.add(Banner("美女","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",2))
        list.add(Banner("美女","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",3))
        list.add(Banner("美女","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",5))
        list.add(Banner("美女","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",4))
        binding.bannerView.refreshData(list)
    }

    private fun initRecyclerView() {

        val list = mutableListOf<HomeEntity>()
        list.add(HomeEntity("one","one","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",0))
        list.add(HomeEntity("two","two","https://tenfei04.cfp.cn/creative/vcg/800/new/VCG211183376288.jpg",1))

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
//            setAdapter(RecommendFragmentRecyclerViewAdapter(viewModel.getHomeEntity()))
            adapter = RecommendFragmentRecyclerViewAdapter(list)
            
        }

    }

    override fun getViewBinding(): MainFragmentRecommendBinding {
        //我是dev 分支的内容
        return MainFragmentRecommendBinding.inflate(layoutInflater)
    }
}