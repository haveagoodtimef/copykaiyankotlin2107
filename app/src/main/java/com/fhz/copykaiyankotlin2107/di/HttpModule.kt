package com.fhz.copykaiyankotlin2107.di

import androidx.room.Insert
import com.fhz.copykaiyankotlin2107.service.KaiYanApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
@Module
@InstallIn(SingletonComponent::class)
class HttpModule {

    @Provides
    @Singleton
    fun provideHttpService(retrofit: Retrofit) : KaiYanApi {
        return retrofit.create(KaiYanApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://baobab.kaiyanapp.com/")
            .client(
                OkHttpClient().newBuilder().addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build())
            .addConverterFactory(GsonConverterFactory.create()) //把字符串转化成类的工厂
            .build()
    }


}