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
@Entity(tableName = "author2")
data class AuthorLocal2 (
    @PrimaryKey val aid: Int,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
)