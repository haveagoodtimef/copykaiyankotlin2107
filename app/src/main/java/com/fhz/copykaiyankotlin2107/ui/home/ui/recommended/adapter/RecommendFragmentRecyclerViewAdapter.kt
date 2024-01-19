package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.baserecyclerviewadapterhelper.entity.HomeEntity
import com.chad.library.adapter4.BaseMultiItemAdapter
import com.fhz.copykaiyankotlin2107.bean.Item
import com.fhz.copykaiyankotlin2107.bean.RecommendEntity
import com.fhz.copykaiyankotlin2107.databinding.MainFragmentRecommendBinding
import com.fhz.copykaiyankotlin2107.databinding.MainRecommendFgItemFollowCardViewBinding
import com.fhz.copykaiyankotlin2107.databinding.MainRecommendFgTitleItemLayoutBinding

/**
 * 时间:2024/1/18
 * @author Mr.Feng
 * 简述: 推荐页面中rv的适配器,使用万能适配器完成
 */
class RecommendFragmentRecyclerViewAdapter(data: List<Item>) : BaseMultiItemAdapter<Item>(data) {

    // 类型 1 的 viewholder
    class ItemVH(val viewBinding: MainRecommendFgItemFollowCardViewBinding) : RecyclerView.ViewHolder(viewBinding.root)


    // 类型 2 的 viewholder
    class TEXT_CARDVH(val viewBinding: MainRecommendFgTitleItemLayoutBinding) : RecyclerView.ViewHolder(viewBinding.root)
//    class FOLLOW_CARDVH(val viewBinding: MainRecommendFgTitleItemLayoutBinding) : RecyclerView.ViewHolder(viewBinding.root)
//    class TEXT_CARDVH(val viewBinding: MainRecommendFgTitleItemLayoutBinding) : RecyclerView.ViewHolder(viewBinding.root)

    // 在 init 初始化的时候，添加多类型
    init {
        addItemType(SQUARE_CARD_COLLECTION, object : OnMultiItemAdapterListener<Item, ItemVH> {
            // 类型 item
            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): ItemVH {
                // 创建 viewholder
                val viewBinding = MainRecommendFgItemFollowCardViewBinding.inflate(LayoutInflater.from(context), parent, false)
                return ItemVH(viewBinding)
            }

            override fun onBind(holder: ItemVH, position: Int, item: Item?) {
                // 绑定 item 数据
                holder.viewBinding.tvTitle.text = item?.data?.title
                Glide.with(context).load(item?.data?.author?.icon).into(holder.viewBinding.ivAuthor)
                Glide.with(context).load(item?.data?.cover?.feed).into(holder.viewBinding.ivVideoCover)

            }


        }).addItemType(TEXT_CARD, object : OnMultiItemAdapterListener<Item, TEXT_CARDVH> { // 类型 title
            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): TEXT_CARDVH {
                // 创建 viewholder
                val viewBinding = MainRecommendFgTitleItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
                return TEXT_CARDVH(viewBinding)
            }

            override fun onBind(holder: TEXT_CARDVH, position: Int, item: Item?) {
                // 绑定 item 数据
                holder.viewBinding.tvTitle.text = item?.data?.title

            }

            override fun isFullSpanItem(itemType: Int): Boolean {
                // 使用GridLayoutManager时，此类型的 item 是否是满跨度
                return false
            }

        })
//            .addItemType(FOLLOW_CARD, object : OnMultiItemAdapterListener<Item, TitleVH> { // 类型 title
//            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): TitleVH {
//                // 创建 viewholder
//                val viewBinding = MainRecommendFgTitleItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
//                return TitleVH(viewBinding)
//            }
//
//            override fun onBind(holder: TitleVH, position: Int, item: Item?) {
//                // 绑定 item 数据
//
//            }
//
//
//
//        }).addItemType(VIDEO_SMALL_CARD, object : OnMultiItemAdapterListener<Item, TitleVH> { // 类型 title
//            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): TitleVH {
//                // 创建 viewholder
//                val viewBinding = MainRecommendFgTitleItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
//                return TitleVH(viewBinding)
//            }
//
//            override fun onBind(holder: TitleVH, position: Int, item: Item?) {
//                // 绑定 item 数据
//
//            }
//
//
//        })

            .onItemViewType { position, list -> // 根据数据，返回对应的 ItemViewType
            when(list[position].type){
                "squareCardCollection" -> SQUARE_CARD_COLLECTION
                "textCard" -> SQUARE_CARD_COLLECTION
                "followCard" -> SQUARE_CARD_COLLECTION
                "videoSmallCard" -> SQUARE_CARD_COLLECTION
                else -> 3
            }
        }
    }

    companion object {
        private const val SQUARE_CARD_COLLECTION = 0
        private const val TEXT_CARD = 1
        private const val FOLLOW_CARD = 2
        private const val VIDEO_SMALL_CARD = 3
    }
}