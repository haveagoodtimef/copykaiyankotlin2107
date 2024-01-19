package com.fhz.copykaiyankotlin2107.ui.home

import com.fhz.copykaiyankotlin2107.bean.RecommendEntity

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
data class HomeUiState (
    val isLoading : Boolean = true,
    val recommendData: RecommendEntity? = null
)