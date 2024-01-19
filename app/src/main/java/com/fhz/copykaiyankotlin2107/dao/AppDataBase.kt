package com.fhz.copykaiyankotlin2107.dao

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
@Database(entities = [AuthorLocal::class,AuthorLocal2::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun authorDao(): AuthorDao
    abstract fun authorDao2(): AuthorDao2
}