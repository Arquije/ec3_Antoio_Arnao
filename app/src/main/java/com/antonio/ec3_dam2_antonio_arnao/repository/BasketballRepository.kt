package com.antonio.ec3_dam2_antonio_arnao.repository

import com.antonio.ec3_dam2_antonio_arnao.model.Player
import com.antonio.ec3_dam2_antonio_arnao.retrofit.BasketballApiService

class BasketballRepository(private val apiService: BasketballApiService) {
    suspend fun getPlayers(): List<Player> {
        return apiService.getPlayers().body()?.data ?: emptyList()
    }

}
