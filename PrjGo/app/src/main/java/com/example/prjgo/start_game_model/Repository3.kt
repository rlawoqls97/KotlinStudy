package com.example.prjgo.start_game_model


class Repository3 {
    suspend fun getPost() : start_game_model {
        return RetrofitInstance3.API.getPost3()
    }
}