package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended.adapter

import com.bumptech.glide.Glide
import com.fhz.copykaiyankotlin2107.R
import com.fhz.copykaiyankotlin2107.bean.Banner
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

/**
 * 时间:2024/1/18
 * @author Mr.Feng
 * 简述: TODO
 */
class BannerAdapter : BaseBannerAdapter<Banner>() {

    override fun bindData(holder: BaseViewHolder<Banner>, data: Banner?, position: Int, pageSize: Int) {
//        holder.setImageResource(R.id.banner_image, data!!.url)
        //Glide
        Glide.with(holder.itemView.context)
            .load(data?.url)
            .into(holder.findViewById(R.id.banner_image))
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.main_banner_item_layout
    }
}