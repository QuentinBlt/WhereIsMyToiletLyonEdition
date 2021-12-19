package com.qbaillet.whereismytoiletlyonedition.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.qbaillet.whereismytoiletlyonedition.Repository.ToiletRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ToiletListViewModel : ViewModel() {
    private val _toilets = mutableStateOf(emptyList<Toilet>())
    val toilets : State<List<Toilet>> = _toilets

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val toiletRepository = ToiletRepository()

    fun load() = effect {
        _isLoading.value = true
        _toilets.value = toiletRepository.getFakeToilets()
        _isLoading.value = false
    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }    // 4
    }

}