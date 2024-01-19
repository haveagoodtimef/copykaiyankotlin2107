package com.fhz.copykaiyankotlin2107.di

import android.content.Context
import androidx.room.Room
import com.fhz.copykaiyankotlin2107.dao.AppDatabase
import com.fhz.copykaiyankotlin2107.dao.AuthorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "a2107"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAuthorDao(appDatabase: AppDatabase): AuthorDao {
        return appDatabase.authorDao()
    }

}