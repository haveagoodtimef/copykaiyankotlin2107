package com.chad.baserecyclerviewadapterhelper.entity

/**
 * @author: limuyang
 * @date: 2019-12-06
 * @Description:
 */
data class HomeEntity(
    val name: String = "",
    val sectionTitle: String = "",
    val url:String = "",
    val type:Int = 0 //0 title // 1 item
)