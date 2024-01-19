package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fhz.copykaiyankotlin2107.bean.RecommendEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecommendViewModel @Inject constructor(private val recommendRepository: RecommendRepository) : ViewModel() {




    fun getRecommendData() {
        viewModelScope.launch {
            val recommendData = recommendRepository.getRecommendData()
            println(recommendData)
        }
    }

}