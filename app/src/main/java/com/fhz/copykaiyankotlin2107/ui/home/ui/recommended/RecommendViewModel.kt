package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fhz.copykaiyankotlin2107.bean.RecommendEntity
import com.fhz.copykaiyankotlin2107.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecommendViewModel @Inject constructor(private val recommendRepository: RecommendRepository) : ViewModel() {


    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    fun getRecommendData() {
        viewModelScope.launch {
            val recommendData = recommendRepository.getRecommendData()
            _homeUiState.update {
                it.copy(isLoading = false, recommendData = recommendData)
            }
        }
    }

}