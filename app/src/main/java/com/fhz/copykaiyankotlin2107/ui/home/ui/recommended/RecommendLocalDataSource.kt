package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import com.fhz.copykaiyankotlin2107.bean.Author
import com.fhz.copykaiyankotlin2107.dao.AuthorDao
import com.fhz.copykaiyankotlin2107.dao.AuthorLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * 时间:2024/1/19
 * @author Mr.Feng
 * 简述: TODO
 */
class RecommendLocalDataSource @Inject constructor(private val authorDao: AuthorDao) {

    suspend fun insertAuthor(author: AuthorLocal){
        //切除协程的上下文
        coroutineScope {
            launch {
                withContext(Dispatchers.IO){
                    authorDao.insertAll(author)
                }
            }
        }
    }
}