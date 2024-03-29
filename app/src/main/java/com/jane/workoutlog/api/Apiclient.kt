package com.jane.workoutlog.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apiclient {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://192.81.215.35")
            .addConverterFactory(GsonConverterFactory.create())

         .build()
        fun <T> buildApiClient(apiInterface: Class<T>): T {
            return retrofit.create(apiInterface)
        }
    }