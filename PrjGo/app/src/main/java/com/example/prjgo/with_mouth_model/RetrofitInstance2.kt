package com.example.prjgo.with_mouth_model

import com.example.prjgo.bal_game_model.BalApi
import com.example.prjgo.with_mouth_model.RetrofitInstance2.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2 {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val API : WithApi by lazy {
        retrofit.create(WithApi::class.java)
    }
    class Constants{
        companion object{
            const val BASE_URL = "http://35.216.83.86:8080/games/"
        }
    }
}