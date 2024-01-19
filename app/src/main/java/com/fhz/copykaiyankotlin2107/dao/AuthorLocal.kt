package com.fhz.copykaiyankotlin2107.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fhz.copykaiyankotlin2107.bean.Follow
import com.fhz.copykaiyankotlin2107.bean.Shield

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
@Entity(tableName = "author")
data class AuthorLocal (
    @PrimaryKey val aid: Int,
    val description: String,
    val expert: Boolean,
    val videoNum: Int
)