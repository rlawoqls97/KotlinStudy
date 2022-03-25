package com.example.prjgo.OX_game_model

import retrofit2.http.GET

interface OXApi {
    @GET("ox-quiz/random")
    suspend fun getPost() : ox_game_model
}