package com.example.prjgo.bal_game_model

import com.example.prjgo.game
import retrofit2.http.GET

interface BalApi {
    @GET("balance-game/random")
    suspend fun getGame() : game
}