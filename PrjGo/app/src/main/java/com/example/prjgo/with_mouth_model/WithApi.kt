package com.example.prjgo.with_mouth_model

import retrofit2.http.GET

interface WithApi {
    @GET("with-one-mouth/random")
    suspend fun getPost2() : with_mouth_model
}