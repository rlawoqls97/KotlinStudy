package com.example.prjgo.Quiz_game_model

import com.example.prjgo.OX_game_model.OXApi
import com.example.prjgo.with_mouth_model.RetrofitInstance2
import com.example.prjgo.with_mouth_model.RetrofitInstance2.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance5 {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val API : QuizApi by lazy {
        retrofit.create(QuizApi::class.java)
    }
    class Constants{
        companion object{
            const val BASE_URL = "http://35.216.83.86:8080/games/"
        }
    }
}