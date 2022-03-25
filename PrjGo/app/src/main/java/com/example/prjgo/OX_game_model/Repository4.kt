package com.example.prjgo.OX_game_model

class Repository4 {
    suspend fun getPost() : ox_game_model{
        return RetrofitInstance4.API.getPost()
    }
}