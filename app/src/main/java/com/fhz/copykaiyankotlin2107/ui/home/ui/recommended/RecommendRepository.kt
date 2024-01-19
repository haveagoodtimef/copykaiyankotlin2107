package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import com.fhz.copykaiyankotlin2107.bean.RecommendEntity
import javax.inject.Inject

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: 推荐fragment的仓库
 */
class RecommendRepository @Inject constructor(
    val recommendLocalDataSource: RecommendLocalDataSource,
    val recommendRemoteDataSource: RecommendRemoteDataSource
){
   suspend fun getRecommendData() : RecommendEntity{
       return recommendRemoteDataSource.getRecommendData()
    }
}