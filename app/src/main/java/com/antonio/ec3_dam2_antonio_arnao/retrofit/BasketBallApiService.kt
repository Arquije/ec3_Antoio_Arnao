package com.antonio.ec3_dam2_antonio_arnao.retrofit

import com.antonio.ec3_dam2_antonio_arnao.model.PlayersResponse
import retrofit2.Response
import retrofit2.http.GET

interface BasketballApiService {
    @GET("players")
    suspend fun getPlayers(): Response<PlayersResponse>

}
