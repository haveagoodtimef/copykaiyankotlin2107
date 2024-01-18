package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.entity.HomeEntity
import com.chad.library.adapter4.BaseMultiItemAdapter
import com.fhz.copykaiyankotlin2107.databinding.MainFragmentRecommendBinding
import com.fhz.copykaiyankotlin2107.databinding.MainRecommendFgItemFollowCardViewBinding
import com.fhz.copykaiyankotlin2107.databinding.MainRecommendFgTitleItemLayoutBinding

/**
 * 时间:2024/1/18
 * @author Mr.Feng
 * 简述: 推荐页面中rv的适配器,使用万能适配器完成
 */
class RecommendFragmentRecyclerViewAdapter(data: List<HomeEntity>) : BaseMultiItemAdapter<HomeEntity>(data) {

    // 类型 1 的 viewholder
    class ItemVH(val viewBinding: MainRecommendFgItemFollowCardViewBinding) : RecyclerView.ViewHolder(viewBinding.root)

    // 类型 2 的 viewholder
    class TitleVH(val viewBinding: MainRecommendFgTitleItemLayoutBinding) : RecyclerView.ViewHolder(viewBinding.root)

    // 在 init 初始化的时候，添加多类型
    init {
        addItemType(ITEM_TYPE, object : OnMultiItemAdapterListener<HomeEntity, ItemVH> { // 类型 item
            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): ItemVH {
                // 创建 viewholder
                val viewBinding = MainRecommendFgItemFollowCardViewBinding.inflate(LayoutInflater.from(context), parent, false)
                return ItemVH(viewBinding)
            }

            override fun onBind(holder: ItemVH, position: Int, item: HomeEntity?) {
                // 绑定 item 数据
                holder.viewBinding.tvTitle.text = "大金人"
            }
        }).addItemType(Title_TYPE, object : OnMultiItemAdapterListener<HomeEntity, TitleVH> { // 类型 title
            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): TitleVH {
                // 创建 viewholder
                val viewBinding = MainRecommendFgTitleItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
                return TitleVH(viewBinding)
            }

            override fun onBind(holder: TitleVH, position: Int, item: HomeEntity?) {
                // 绑定 item 数据
                holder.viewBinding.tvTitle.text = "精选"
            }

            override fun isFullSpanItem(itemType: Int): Boolean {
                // 使用GridLayoutManager时，此类型的 item 是否是满跨度
                return true;
            }

        }).onItemViewType { position, list -> // 根据数据，返回对应的 ItemViewType
            if (list[position].type == 0) {
                Title_TYPE
            } else {
                ITEM_TYPE
            }
        }
    }

    companion object {
        private const val Title_TYPE = 0
        private const val ITEM_TYPE = 1
    }
}