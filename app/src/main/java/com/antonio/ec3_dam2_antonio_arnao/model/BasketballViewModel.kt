package com.antonio.ec3_dam2_antonio_arnao.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonio.ec3_dam2_antonio_arnao.repository.BasketballRepository
import kotlinx.coroutines.launch

class BasketballViewModel(private val repository: BasketballRepository) : ViewModel() {
    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    private val _selectedPlayer = MutableLiveData<Player>()
    val selectedPlayer: LiveData<Player> = _selectedPlayer

    fun getPlayers() {
        viewModelScope.launch {
            _players.value = repository.getPlayers()
        }
    }
}

