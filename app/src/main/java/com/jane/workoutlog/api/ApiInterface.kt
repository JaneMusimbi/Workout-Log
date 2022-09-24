package com.jane.workoutlog.api


import com.jane.workoutlog.models.LogInResponse
import com.jane.workoutlog.models.RegisterRequest
import com.jane.workoutlog.models.RegisterResponse
import com.jane.workoutlog.models.loginRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/logIn")
    suspend fun loginUser(@Body loginRequest: loginRequest):Response<LogInResponse>
}