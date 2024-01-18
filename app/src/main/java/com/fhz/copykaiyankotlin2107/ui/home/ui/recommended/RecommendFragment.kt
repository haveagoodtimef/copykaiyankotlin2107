package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import android.widget.SimpleAdapter
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.fhz.copykaiyankotlin2107.R
import com.fhz.copykaiyankotlin2107.base.BaseFragment
import com.fhz.copykaiyankotlin2107.bean.Banner
import com.fhz.copykaiyankotlin2107.databinding.MainFragmentRecommendBinding
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


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

        //初始化banner
        binding.bannerView.setLifecycleRegistry(lifecycle)
            .setAdapter(object : BaseBannerAdapter<Banner>() {
                override fun bindData(
                    holder: BaseViewHolder<Banner>?,
                    data: Banner?,
                    position: Int,
                    pageSize: Int
                ) {

//                    holder?.itemView?.context?.let {
//                        Glide.with(it)
//                            .load(data?.url)
//                            .into()
//                    }
                    holder?.setImageResource(R.id.banner_image,R.drawable.ic_book_white_24dp)

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

    override fun getViewBinding(): MainFragmentRecommendBinding {
        return MainFragmentRecommendBinding.inflate(layoutInflater)
    }
}