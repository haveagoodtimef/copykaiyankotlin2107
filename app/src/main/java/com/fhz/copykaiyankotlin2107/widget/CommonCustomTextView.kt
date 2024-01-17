package com.fhz.copykaiyankotlin2107.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * 时间:2024/1/17
 * @author Mr.Feng
 * 简述: TODO
 */
class CommonCustomTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {
    init {
        // 获取资源文件
        val assets = context.assets
        val font = Typeface.createFromAsset(assets, "fonts/Lobster-1.4.otf")
        typeface = font
    }
}