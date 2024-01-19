package com.fhz.copykaiyankotlin2107.service

import com.fhz.copykaiyankotlin2107.bean.RecommendEntity
import retrofit2.http.GET

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */

interface KaiYanApi {

    @GET("api/v5/index/tab/allRec")
    suspend fun getHomeRecommendFragmentData() : RecommendEntity
}