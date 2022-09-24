package com.jane.workoutlog.Repository

import com.jane.workoutlog.api.ApiInterface
import com.jane.workoutlog.api.Apiclient
import com.jane.workoutlog.models.LogInResponse
import com.jane.workoutlog.models.RegisterRequest
import com.jane.workoutlog.models.RegisterResponse
import com.jane.workoutlog.models.loginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = Apiclient.buildApiClient(ApiInterface::class.java)
    suspend fun LoginUser(loginRequest: loginRequest): Response<LogInResponse>
    = withContext(Dispatchers.IO) {
            var response = apiClient.loginUser(loginRequest)
            return@withContext response
        }
    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>
            = withContext(Dispatchers.IO) {
        var response = apiClient.registerUser(registerRequest)
        return@withContext response
    }
}

