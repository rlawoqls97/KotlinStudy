package com.example.prjgo.start_game_model

import com.example.prjgo.with_mouth_model.RetrofitInstance2.Constants.Companion.BASE_URL
import com.example.prjgo.with_mouth_model.WithApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance3 {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val API : StartApi by lazy {
        retrofit.create(StartApi::class.java)
    }
    class Constants{
        companion object{
            const val BASE_URL = "http://35.216.83.86:8080/games/"
        }
    }
}