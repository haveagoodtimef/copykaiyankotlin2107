package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.entity.HomeEntity
import com.fhz.copykaiyankotlin2107.R
import com.fhz.copykaiyankotlin2107.databinding.MainRecommendFgTitleItemLayoutBinding

/**
 * 时间:2024/1/18
 * @author Mr.Feng
 * 简述: 原生的适配器
 */
class RecommendFragmentRecyclerViewAdapter2(val context:Context, val list : List<HomeEntity>) : RecyclerView.Adapter<RecommendFragmentRecyclerViewAdapter2.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv:TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        if(viewType == 0){
            val inflate = MainRecommendFgTitleItemLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
            return ViewHolder(inflate.root)
//        }else{
//            return ViewHolder()
//        }

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(getItemViewType(position) == 0) {
            holder.tv.text = list[position].name

        }else{

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0){
            Title_TYPE
        }else{
            ITEM_TYPE
        }

    }

    companion object{
        private const val Title_TYPE = 0
        private const val ITEM_TYPE = 1
        private const val FOOTER_TYPE = 2
    }
}