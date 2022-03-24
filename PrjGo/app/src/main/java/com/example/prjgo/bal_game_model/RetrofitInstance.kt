package com.example.prjgo.bal_game_model

import com.example.prjgo.bal_game_model.RetrofitInstance.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val API : BalApi by lazy {
        retrofit.create(BalApi::class.java)
    }
    class Constants{
        companion object{
            const val BASE_URL = "http://35.216.83.86:8080/games/"
        }
    }
}