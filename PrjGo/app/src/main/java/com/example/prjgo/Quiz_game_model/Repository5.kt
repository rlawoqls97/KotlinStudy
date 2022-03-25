package com.example.prjgo.Quiz_game_model

class Repository5 {
    suspend fun getPost() : quiz_game_model{
        return RetrofitInstance5.API.getPost()
    }
}