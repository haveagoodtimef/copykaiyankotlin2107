package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import com.fhz.copykaiyankotlin2107.bean.RecommendEntity
import com.fhz.copykaiyankotlin2107.service.KaiYanApi
import javax.inject.Inject

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: 远程数据来源于retrofit
 */

class RecommendRemoteDataSource @Inject constructor (private val kaiYanApi: KaiYanApi) {

   suspend fun getRecommendData() : RecommendEntity {
        return kaiYanApi.getHomeRecommendFragmentData()
    }
}