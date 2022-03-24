package com.example.prjgo.bal_game_model

import com.example.prjgo.game

class Repository {
    suspend fun getPost() : game {
        return RetrofitInstance.API.getGame()
    }
}