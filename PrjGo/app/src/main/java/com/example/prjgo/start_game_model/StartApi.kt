package com.example.prjgo.start_game_model

import retrofit2.http.GET

interface StartApi {
    @GET("start-game/random")
    suspend fun getPost3() : start_game_model
}