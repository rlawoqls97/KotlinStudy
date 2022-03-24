package com.example.prjgo.with_mouth_model

class Repository2 {
    suspend fun getPost() : with_mouth_model {
        return RetrofitInstance2.API.getPost2()
    }
}