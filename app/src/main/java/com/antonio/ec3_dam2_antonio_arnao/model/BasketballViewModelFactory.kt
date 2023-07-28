package com.antonio.ec3_dam2_antonio_arnao.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antonio.ec3_dam2_antonio_arnao.repository.BasketballRepository

class BasketballViewModelFactory(private val repository: BasketballRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BasketballViewModel::class.java)) {
            return BasketballViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
