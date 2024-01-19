package com.fhz.copykaiyankotlin2107.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
@Dao
interface AuthorDao {
    @Query("SELECT * FROM author")
    fun getAll(): Flow<List<AuthorLocal>>

    @Insert
    fun insertAll(vararg authorLocal: AuthorLocal)

    @Delete
    fun delete(authorLocal: AuthorLocal)
}