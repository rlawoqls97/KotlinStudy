package com.example.prjgo.Quiz_game_model

import retrofit2.http.GET

interface QuizApi {
    @GET("quiz/random")
    suspend fun getPost() : quiz_game_model
}